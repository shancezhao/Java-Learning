CREATE DATABASE Group4_Restaurant


USE Group4_Restaurant;

--DROP DATABASE Group4_Restaurant
CREATE TABLE UserAccount(
	UserID INT IDENTITY(1,1) NOT NULL,
	UserType VARCHAR(50) CHECK(UserType IN ('Customer','Restaurant','Dispatcher')),
	UserName VARCHAR(50) UNIQUE,
	EncryptedPassword VARBINARY(250),		--Use the Encrypt
	PRIMARY KEY (UserID)
);

CREATE TABLE Restaurant(
	RestaurantID INT IDENTITY(1,1) NOT NULL,
	UserID INT NOT NULL,
	Rest_Owner VARCHAR(100),
	Rest_Name VARCHAR(100),
	Rest_Address VARCHAR(200),
	Rest_Service_Time VARCHAR(100),
	Rest_Phone VARChAR(50),
	Rest_Rating INT,
	--PRIMARY KEY (RestaurantID),
	FOREIGN KEY (UserID) REFERENCES UserAccount(userID)
);

--Add a Primary Key to Table Restaurant
ALTER TABLE Restaurant ADD PRIMARY KEY (RestaurantID);

CREATE TABLE Dish_Detail(
	DishID INT IDENTITY(1,1) NOT NULL,
	Dish_Name VARCHAR(50) NOT NULL,
	Dish_Price MONEY,
	Dish_Catalog VARCHAR(50),
	Dish_Description VARCHAR(200),
	PRIMARY KEY (DishID),
);

CREATE TABLE Menu(
	MenuID INT IDENTITY(1,1) NOT NULL,
	RestaurantID INT NOT NULL,
	DishID INT NOT NULL UNIQUE,			
	PRIMARY KEY (MenuID),
	FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID),
	FOREIGN KEY (DishID) REFERENCES Dish_Detail(DishID)
);

CREATE TABLE Customer(
	CustomerID INT IDENTITY(1,1) NOT NULL,
	UserID INT NOT NULL,
	Customer_FirstName VARCHAR(50),
	Customer_LastName VARCHAR(50),
	Customer_Address VARCHAR(100),
	Customer_BirthDate DATE,
	Customer_Email VARCHAR(100),
	Customer_Phone VARCHAR(50),
	Customer_Gender VARCHAR(2) CHECK(Customer_Gender IN ('F','M')),
	Customer_AdditionalNotes VARCHAR(200),
	PRIMARY KEY (CustomerID),
	FOREIGN KEY (UserID) REFERENCES UserAccount(userID)
);
--ALTER TABLE Customer ADD Customer_Zipcode VARCHAR(5);

CREATE TABLE Employee(
	EmployeeAutoID INT IDENTITY(1,1) NOT NULL,
	EmployeeID AS ('E-' + RIGHT('0000' + CONVERT(varchar(4), EmployeeAutoID), 4)) PERSISTED, 
	Employee_FirstName VARCHAR(20),
	Employee_LastName VARCHAR(20),
	Employee_Phone VARCHAR(30),
	Employee_EncryptedSSN VARBINARY(250),
	PRIMARY KEY (EmployeeID)		
);

CREATE TABLE Cards(
	CardID INT IDENTITY(1,1) NOT NULL,
	UserID INT NOT NULL,
	NameOnCard VARCHAR(50) NOT NULL,
	EncryptedCard_Number VARBINARY(250) NOT NULL,
	EncryptedSecurity_Number VARBINARY(250) NOT NULL,		--Use the Encrypt
	Expire_Date DATE CHECK (Expire_Date>CAST(GETDATE() AS DATE)),  																			
	PRIMARY KEY (CardID),
	FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

CREATE TABLE Dispatcher(
	DispatcherID INT IDENTITY(1,1) NOT NULL,
	UserID INT NOT NULL,
	EmployeeID VARCHAR(6) UNIQUE,
	VehicleInfo VARCHAR(50),
	PRIMARY KEY (DispatcherID),
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
	FOREIGN KEY (UserID) REFERENCES UserAccount(UserID)
);

CREATE TABLE Coupon(
	CouponID INT IDENTITY(1,1) NOT NULL,
	--OrderID INT NOT NULL,
	Descriptions VARCHAR(200),
	CouponValue Money,
	Expire_Date DATE,
	PRIMARY KEY (CouponID),
	--FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
)

CREATE TABLE Orders(
	OrderID INT IDENTITY(1,1) NOT NULL,
	DispatcherID INT NOT NULL,
	RestaurantID INT NOT NULL,
	UserID INT NOT NULL,
	Order_Time DATE,						--Auto Generate By System Time
	CouponID INT NOT NULL DEFAULT '1',
	OrignialPrice Money,					--Computed by Trigger
	FinalPrice Money,						--Computed by Trigger
	Order_Status VARCHAR(50),				--Set default as "processing"£¬and can be only changed to ¡°finished¡±
	PRIMARY KEY (OrderID),
	FOREIGN KEY (DispatcherID) REFERENCES Dispatcher(DispatcherID),
	FOREIGN KEY (RestaurantID) REFERENCES Restaurant(RestaurantID),
	FOREIGN KEY (UserID) REFERENCES UserAccount(UserID),
	FOREIGN KEY (CouponID) REFERENCES Coupon(CouponID),
);
CREATE TABLE Order_Detail(
	OrderDetailID INT IDENTITY(1,1) NOT NULL,
	OrderID INT NOT NULL,
	DishID INT NOT NULL,
	Dish_Amount INT,
	Price MONEY,							--Computed by Trigger
	PRIMARY KEY (OrderDetailID),
	FOREIGN KEY (DishID) REFERENCES Dish_Detail(DishID),
);

CREATE TABLE Payment(
	PaymentID INT IDENTITY(1,1) NOT NULL,
	OrderID INT,
	CardID INT,
	PRIMARY KEY (PaymentID),
	FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
	FOREIGN KEY (CardID) REFERENCES Cards(CardID)
);

CREATE TABLE Comments(
	CommentsID INT IDENTITY(1,1) NOT NULL,
	OrderID INT NOT NULL,
	Rating INT CHECK(Rating>=0 AND Rating<=10),			--check in [0,10]
	Customer_Message VARCHAR(200),
	PRIMARY KEY (CommentsID),
	FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
);

--Check email format in Customer table
Create FUNCTION res_ValidateEmail (@email varChar(100))	--Customer

RETURNS bit
AS
BEGIN
RETURN
(
SELECT 
	CASE 
		When 	@Email is null then 0	                	--NULL Email is invalid
		When	charindex(' ', @email) 	<> 0 or		--Check for invalid character
				charindex('/', @email) 	<> 0 or --Check for invalid character
				charindex(':', @email) 	<> 0 or --Check for invalid character
				charindex(';', @email) 	<> 0 then 0 --Check for invalid character
		When len(@Email)-1 <= charindex('.', @Email) then 0--check for '%._' at end of string
		When 	@Email like '%@%@%'or 
				@Email Not Like '%@%.%'  then 0--Check for duplicate @ or invalid format
		Else 1
	END
)
END

GO

CREATE MASTER KEY
ENCRYPTION BY PASSWORD = 'Re@staurant_Psw';

-- Create certificate to protect symmetric key
CREATE CERTIFICATE RestCertificate
WITH SUBJECT = 'Restaurant Certificate',
EXPIRY_DATE = '2026-10-31';

-- Create symmetric key to encrypt data
CREATE SYMMETRIC KEY RestSymmetricKey
WITH ALGORITHM = AES_128
ENCRYPTION BY CERTIFICATE RestCertificate;

-- Open symmetric key
OPEN SYMMETRIC KEY RestSymmetricKey
DECRYPTION BY CERTIFICATE RestCertificate;


GO

--Create VIEW
CREATE VIEW EmployeeList
AS
SELECT EmployeeID, Employee_LastName, Employee_FirstName
FROM Employee;

GO

CREATE VIEW CustomerList
AS 
SELECT CustomerID,Customer_FirstName,Customer_LastName,Customer_Zipcode,Customer_Gender
FROM Customer

GO

CREATE VIEW OrderList
AS
SELECT OrderID,DishID,Dish_Amount
FROM Order_Detail

GO


--Update Price for Order_Detail after insert
CREATE TRIGGER get_PriceInOrderDetail
ON Order_Detail
AFTER INSERT
AS
BEGIN
	SET NOCOUNT ON;
	DECLARE @Price MONEY;
	DECLARE @DishID INT;
	DECLARE @Dish_Price MONEY;
	DECLARE @Dish_Amount INT;
	DECLARE @OrderDetailID INT;
	SELECT @Dish_Amount = i.Dish_Amount
		FROM Inserted i
		JOIN Order_Detail od
			ON i.OrderID = od.OrderID
	SELECT @DishID = i.DishID
		FROM Inserted i
		JOIN Order_Detail od
		ON i.OrderID = od.OrderID

	SELECT @Dish_Price = Dish_Price
		FROM Dish_Detail
		WHERE DishID = @DishID;
	SELECT @OrderDetailID = od.OrderDetailID
		FROM Inserted i
		JOIN Order_Detail od
		ON i.OrderID = od.OrderID
		WHERE i.DishID=@DishID
	SET @Price = @Dish_Amount * @Dish_Price;
	UPDATE Order_Detail SET Price = @Price
	WHERE OrderDetailID = @OrderDetailID 
END;
GO


--Rating for Restaurant
CREATE TRIGGER Rating_Restaurant
ON Comments
AFTER INSERT AS

BEGIN
	DECLARE @RestaurantID INT;
	DECLARE @Rating INT;
	DECLARE @Counts INT;

	SELECT @RestaurantID=r.RestaurantID,@Rating=AVG(Rating)
		FROM Restaurant r, Orders o, Comments c
		WHERE c.OrderID=o.OrderID AND o.RestaurantID=r.RestaurantID
	GROUP BY r.RestaurantID;

	UPDATE Restaurant SET Rest_Rating = @Rating
		WHERE RestaurantID = @RestaurantID
END;

GO

--OriginalPrice
CREATE TRIGGER get_OrignialPriceforOrder
ON Order_Detail
AFTER INSERT AS
BEGIN
	
	DECLARE @OrderID INT;
	DECLARE @OriginalPrice MONEY;

	SELECT @OrderID=od.OrderID,@OriginalPrice=SUM(od.Price)
		FROM Order_Detail od, Orders o
		WHERE od.OrderID=o.OrderID
		GROUP BY od.OrderId;
	UPDATE Orders SET OrignialPrice = @OriginalPrice
		WHERE OrderID = @OrderID
END;

GO


--FinalPrice
CREATE TRIGGER get_FinalPriceforOrder
ON Orders
AFTER UPDATE AS

	DECLARE @CouponID INT;
	DECLARE @CouponValue MONEY;
	DECLARE @OriginalPrice MONEY;
	DECLARE @FinalPrice MONEY;
	IF UPDATE(OrignialPrice)
	BEGIN
		DECLARE CursorFinal CURSOR
		FOR
		SELECT OrignialPrice, CouponValue
			FROM Orders o, Coupon c
			WHERE o.CouponID=c.CouponID
		OPEN CursorFinal
		FETCH NEXT FROM CursorFinal INTO @OriginalPrice,@CouponValue
		WHILE(@@FETCH_STATUS=0)
		BEGIN
			SET @FinalPrice = @OriginalPrice + @CouponValue;
			
			UPDATE Orders SET FinalPrice = @FinalPrice
			WHERE OrignialPrice = @OriginalPrice
			FETCH NEXT FROM CursorFinal INTO @OriginalPrice,@CouponValue
		END
		CLOSE CursorFinal
		DEALLOCATE CursorFinal;	
	END;

--check current trigger
SELECT * FROM Sysobjects WHERE xtype = 'TR'

--delete the trigger
IF OBJECT_ID ('odd_GetPriceForOrder', 'TR') IS NOT NULL  
   DROP TRIGGER odd_GetPriceForOrder;  
GO

--Insert data into UserAccount
INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Zoe',EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678001'));

INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Kart', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678002'));

	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Tian', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));


	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer4', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));

INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer5', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer6', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer7', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer8', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer9', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Customer','Customer10', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));


	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant1', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant2', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant3', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant4', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant5', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant6', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant7', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant8', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant9', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Restaurant','Restaurant10', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));


	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher1', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));	
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher2', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));	
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher3', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher4', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher5', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher6', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher7', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
	
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher8', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
		
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher9', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));
			
	INSERT INTO UserAccount(
	UserType,
	UserName,
	EncryptedPassword
	)
	VALUES('Dispatcher','Dispatcher10', EncryptByKey(Key_GUID(N'RestSymmetricKey'), '5678111'));



--Insert data into Dish_Detail
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	)
	VALUES('5 Wings with BBQ', '7.99', 'Appetizer','Tasty');

INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Kung Pao Chicken', '15.5', 'Main','Tasty Chinese Food');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Spicy Beef Noodle', '13.8', 'Main','Large');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Hamburger with French Fries', '8.99', 'Main','Tasty');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Rib with Red Wine', '21', 'Main','Tasty');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Seafood Fried Rice', '15', 'Main','Tasty');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Chocolate Cake', '6', 'Dessert','Sweet');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Chicken Noodle Soup', '3.99',  'Appetizer','Tasty');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Sushi', '7.63', 'Appetizer','Tasty');
INSERT INTO Dish_Detail(
	Dish_Name,
	Dish_Price,
	Dish_Catalog,
	Dish_Description
	) VALUES('Salad', '5.6', 'Appetizer','Tasty');



--Insert data into Restaurant
 INSERT INTO Restaurant(
	UserID,
	Rest_Owner,
	Rest_Name,
	Rest_Address,
	Rest_Service_Time,
	Rest_Phone
	)
	VALUES (11,'Johnny Oven', 'Shun Kitchen', '172 Hemenway Street, Boston, MA','11:00-22:00', '6177020020');
 INSERT INTO Restaurant(
	UserID,
	Rest_Owner,
	Rest_Name,
	Rest_Address,
	Rest_Service_Time,
	Rest_Phone)
 VALUES (12,'Gladys Z. Senter', 'Brownville Volunteer Fire Dept.', 
 '173 Hemenway Street, Boston, MA','11:00-22:00', '6177020101');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (13,'Shirley K. Camberos', 'Syracuse Model Neighborhood Facility', '174 Hemenway Street, Boston, MA','11:00-22:00', '6177020102');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (14,'Ana Q. Vannatter', 'The Touch Of Europe', '175 Hemenway Street, Boston, MA','11:00-22:00', '6177020103');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (15,'Sue J. Tapia', 'Bella Pizza2', '176 Hemenway Street, Boston, MA','11:00-22:00', '6177020104');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (16,'Kathryn Y. Berens', 'Maureen Mullanys Pub', '177 Hemenway Street, Boston, MA','11:00-22:00', '6177020105');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (17,'Katherine A. Willner', 'Falafel King', '178 Hemenway Street, Boston, MA','11:00-22:00', '6177020106');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (18,'Marsha K. Cantrell', 'Santo Pizzeria', '179 Hemenway Street, Boston, MA','11:00-22:00', '6177020107');
 
 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (19,'Melinda G. Saltsman', 'Marisco El Veneno', '178 Hillside Street, Boston, MA','11:00-22:00', '6177020108');

 INSERT INTO Restaurant(
 UserID,
 Rest_Owner,
 Rest_Name,
 Rest_Address,
 Rest_Service_Time,
 Rest_Phone
 )
 VALUES (20,'Tamara W. Coss', 'San Souci', '198 Hillside Street, Boston, MA','11:00-22:00', '6177020109');


--Insert data into Menu
INSERT Menu(RestaurantID,DishID) VALUES(1, 1);
INSERT Menu(RestaurantID,DishID) VALUES(2, 2);
INSERT Menu(RestaurantID,DishID) VALUES(3, 3);
INSERT Menu(RestaurantID,DishID) VALUES(4, 4);
INSERT Menu(RestaurantID,DishID) VALUES(5, 5);
INSERT Menu(RestaurantID,DishID) VALUES(6, 6);
INSERT Menu(RestaurantID,DishID) VALUES(7, 7);
INSERT Menu(RestaurantID,DishID) VALUES(8, 8);
INSERT Menu(RestaurantID,DishID) VALUES(9, 9);
INSERT Menu(RestaurantID,DishID) VALUES(10, 10);


--Insert data into Coupon table
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('No Coupon', 0,'2222-12-31');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon1', -3,'2018-10-01');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon2', -2,'2020-11-21');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon3', -2,'2018-10-01');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon4',-3,'2019-02-20');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon5',-2,'2018-01-01');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon6',-1,'2017-12-31');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon7',-5,'2020-07-11');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon8', -10,'2019-11-11');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon9', -3,'2018-10-01');
INSERT Coupon(
	Descriptions,
	CouponValue,
	Expire_Date
	) 
	VALUES('Coupon10',-3,'2018-03-01');

--Insert data into Employee

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN			--Use the Encrypt
)
VALUES
('Nick','Smith', '+1 6177305678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-98-8910')));

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN
)
VALUES
('Yi','Chai', '+1 6172598761' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-98-8910')));

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN
)
VALUES
('Shengsi','Zhao', '+1 6177305688' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-98-8920')));


INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN
)
VALUES
('Rui','Sun', '+1 6173705678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '757-98-8910')));


INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN
)
VALUES
('Li','Guo', '+1 6188305678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '547-61-8910')));


INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN
)
VALUES
('Shu','Zhang', '+1 617735678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-98-8910')));


INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN
)
VALUES
('You','Zhang', '+1 6177270678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '123-98-8910')));

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN		
)
VALUES
('Kaiying','Song', '+1 6175675678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-10-8910')));

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN		
)
VALUES
('Xiongxiong','Gu', '+1 4537305678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-98-8947')));

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN			
)
VALUES
('Sam','Smith', '+1 6177665678' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '776-98-8910')));

INSERT INTO Employee(
	Employee_FirstName,
	Employee_LastName,
	Employee_Phone,
	Employee_EncryptedSSN		
)
VALUES
('John','Smith', '+1 6177306081' ,
EncryptByKey(Key_GUID(N'RestSymmetricKey'), 
convert(varbinary, '666-98-1010')));


--Insert data into Dispatcher
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(21,'E-0001','Bike');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(22,'E-0002','Motorcycle');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(23,'E-0003','Motorcycle');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(24,'E-0004','Motorcycle');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(25,'E-0005','Motorcycle');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(26,'E-0006','Car');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(27,'E-0007','Car');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(28,'E-0008','Car');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(29,'E-0009','Bike');
INSERT Dispatcher(userID,EmployeeID,VehicleInfo) VALUES(30,'E-0010','Car');



--Insert data into Customer
INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(1,'Zoe','Jones','20th Washington Street, Boston, MA, 02115','1993-08-08','c7@gmail.com','7777777','M','None');


INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(2,'Kate','Washington','623 Little Springs Rd, Smithdale, MS, 39664','1994-08-09','an1@gmail.com','7777777','F','Good');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(3,'Doreen','Foster','110 Fargo Way, Folsom, CA, 95630','2000-08-08','df1@gmail.com','7777777','M','Notes');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(4,'Levi','Montgomery','856 Chapman Rd, Pelham, NC, 27311','1996-08-08','lm1@gmail.com','88888888','M','Notes');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(5,'Yoyo A.','Meyer','26213 21st Hwy, Angie, LA, 70426','1989-01-08','wr1@gmail.com','7777777','F','Notes');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(6,'Lucas','Pearson','2505 E Pawnee Rd, Garden City, KS, 67846','1933-08-08','op1@gmail.com','7777777','M','Notes');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(7,'Hanna','Swift','7501 W Brazito Rd, Jefferson City, MO, 65109','1967-01-08','ys1@gmail.com','7777777','F','Notes');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(8,'Karen','Underwood','50 Common St, Lawrence, MA, 01840 ','1934-08-08','ku1@qq.com','7777777','M','Notes');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(9,'Yuhan','Tan','69 Norman St, Everett, MA, 02149','1966-01-08','gb1@gmail.com','7777777','F','No');
 
 INSERT Customer(
 UserID,
 Customer_FirstName,
 Customer_LastName,
 Customer_Address,
 Customer_BirthDate,
 Customer_Email,
 Customer_Phone,
 Customer_Gender,
 Customer_AdditionalNotes
 ) VALUES(10,'Amos','Sanchez
 ','3400 Bountiful Ln, Woodbridge, VA, 22193','1933-08-08','as1@qq.com','7777777','F','No');


 INSERT into Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	)
	VALUES(1,'Zoe Jones',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '440011102234098')),EncryptByKey(Key_GUID(N'RestSymmetricKey'),
	 CONVERT(varbinary, '123-45-6789')),CONVERT(DATE,'2020-10-01'));


INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(2,'Kate Washington',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '440011102234088')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '345-27-6709')),CONVERT(DATE,'2020-05-22'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(3,'Doreen Foster',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '440008702293188')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '158-01-6709')),CONVERT(DATE,'2020-05-22'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(4,'Levi Montgomery',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '440385618140811')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '345-27-6091')),CONVERT(DATE,'2020-10-02'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(5,'Yoyo A. Meyer',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '673811102134019')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '333-10-0189')),CONVERT(DATE,'2022-05-19'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(6,'Lucas Pearson',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '330011102234986')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '987-66-1010')),CONVERT(DATE,'2025-03-21'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(7,'Hanna Swift',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '401013102234654')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '666-11-5671')),CONVERT(DATE,'2020-05-22'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(8,'Karen Underwood',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '410351072234081')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '889-12-3321')),CONVERT(DATE,'2022-05-19'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(9,'Yuhan Tan',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '407202203808138')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '981-10-2315')),CONVERT(DATE,'2020-05-22'));
INSERT Cards(
	UserID,
	NameOnCard,
	EncryptedCard_Number,
	EncryptedSecurity_Number,
	Expire_Date
	) VALUES(10,'Cathorine Biber',EncryptByKey(Key_GUID(N'RestSymmetricKey'), convert(varbinary, '401110202234088')),EncryptByKey(Key_GUID(N'RestSymmetricKey'), CONVERT(varbinary, '345-27-670')),CONVERT(DATE,'2020-05-22'));


ALTER TABLE Orders 
ADD CONSTRAINT timegenerate
DEFAULT GETDATE() FOR Order_time ;
GO

ALTER TABLE Orders 
ADD CONSTRAINT statusgenerate
DEFAULT 'processing' FOR Order_Status ;
GO

--Insert data into Orders
INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID) VALUES(1,1,1,2)

INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(2,2,2,2);
 
  INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(3,3,3,3);
 
  INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(4,4,4,4);

 INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(5,5,5,5);

INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(6,6,6,6);
 
  INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(7,7,7,7);
 
  INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(8,8,8,8);
 
  INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(9,9,9,9);
 
INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(10,10,10,10);

INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID
 ) VALUES(3,1,10);

INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(5,10,2,3);

INSERT Orders(
 DispatcherID,
 RestaurantID,
 UserID,
 CouponID
 ) VALUES(1,5,4,1);


 
 --Insert data into Comments
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(1, 9,'Awesome');		
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(2, 9,'Awesome');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(3, 8,'Good');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(4, 8,'Good');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(5, 2,'Bad');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(6, 5,'Nice');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(7, 5,'Nice');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(8, 1,'Really Terrible');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(9, 7,'Awesome');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(10, 9,'Perfect dinner');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(11, 3,'The dish is cold');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(12, 7,'Good');
INSERT Comments(OrderID,Rating,Customer_Message) VALUES(13, 6,'Nice');

--Insert data into Order_Detail
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(1, 1, 1);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(1, 4, 2);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(2, 2, 1);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(3, 3, 2);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(4, 4, 3);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(5, 5, 1);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(6, 6, 3);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(7, 7, 1);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(8, 8, 4);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(9, 9, 2);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(10, 10, 5);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(11, 3, 3);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(11, 1, 1);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(12, 5, 1);
INSERT INTO Order_Detail(OrderID,DishID,Dish_Amount) VALUES(13, 3, 2);


--Insert data into Payment
INSERT Payment(OrderID,CardID) VALUES(1, 1);
INSERT Payment(OrderID,CardID) VALUES(2, 2);
INSERT Payment(OrderID,CardID) VALUES(3, 3);
INSERT Payment(OrderID,CardID) VALUES(4, 4);
INSERT Payment(OrderID,CardID) VALUES(5, 5);
INSERT Payment(OrderID,CardID) VALUES(6, 6);
INSERT Payment(OrderID,CardID) VALUES(7, 7);
INSERT Payment(OrderID,CardID) VALUES(8, 8);
INSERT Payment(OrderID,CardID) VALUES(9, 9);
INSERT Payment(OrderID,CardID) VALUES(10, 10);
INSERT Payment(OrderID,CardID) VALUES(11, 10);
INSERT Payment(OrderID,CardID) VALUES(12, 2);
INSERT Payment(OrderID,CardID) VALUES(13, 4);

--Use import wizard to get data from wage.xls
alter table wage add TotalWage float
update Wage set TotalWage = bonus+basewage+(Workinghour*hourlywage);
GO

--Check all the certificate
SELECT name, pvt_key_encryption_type_desc, issuer_name  
FROM sys.certificates  

--Show the Decrypted infomation
OPEN SYMMETRIC KEY RestSymmetricKey
DECRYPTION BY CERTIFICATE RestCertificate; 
GO  
SELECT UserName, convert(varchar, DecryptByKey(EncryptedPassword))
FROM UserAccount;