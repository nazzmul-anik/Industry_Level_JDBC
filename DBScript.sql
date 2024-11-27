CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllEmployees`()
BEGIN
Select *from employee;
END
=================================================================
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmployeeById`(IN empId INT)
BEGIN
select *from employee where employee_id = empId;
END
=======================================================================
CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmployeeNameAndSalaryById`(IN empId INT, OUT empName varchar(100), out empSal double)
BEGIN
select employee_name, employee_salary into empName, empSal from employee where employee_id = empId;
END