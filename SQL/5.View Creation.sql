--Create VIEW
USE Group4_Restaurant;
CREATE VIEW EmployeeList
AS
SELECT EmployeeID, Employee_LastName, Employee_FirstName
FROM Employee;

GO

CREATE VIEW CustomerList
AS 
SELECT CustomerID,Customer_FirstName,Customer_LastName,Customer_Gender
FROM Customer

GO

CREATE VIEW OrderList
AS
SELECT OrderID,DishID,Dish_Amount
FROM Order_Detail
