USE shop; 

#-------------------------------- 10 STATEMENTS OF INSERTION ---------------------------------

/*INSERT INTO clients (idClients, name_clients, last_name_clients, age_clients, phone_clients, email_clients) VALUES 
('1','Andres', 'Limpio', '29', '1234567890', 'alimpio.laba@solvd.com'),
('2','Alejandro', 'Diaz', '32', '1234497890', 'adiaz.laba@solvd.com'),
('3','Mary', 'Sue', '49', '3334567890', 'msue.laba@solvd.com'),
('4','Oliver', 'Atom', '21', '9232562291', 'oatom.laba@solvd.com');*/



/*INSERT INTO payments (id_payments, idOrders, amount_payments, date_payments) VALUES ('208','6573','94.5','2023-01-16');
INSERT INTO shippers (idShippers, company_name_shippers) VALUES ('2960','DHL');
INSERT INTO delivery_has_shippers (idDelivery, idShippers, date_creation) VALUES ('202023','2960','2023-01-16');
INSERT INTO detail_orders (idDetail_orders, idOrders, idProducts) VALUES ('1','6573','987505');/*


/*INSERT INTO employees (idEmployees, name_employees, last_name_employees, age_employees, phone_employees, email_employees, salary_employees, Offices_idOffices) VALUES 
('1','Tom', 'Might', '19', '5234566890', 'tmight.laba@solvd.com','1550.0', '18479'),
('2','Albert', 'Fujima', '22', '2234497899', 'afujima.laba@solvd.com', '1550.0', '18480'),
('3','Maria', 'Maso', '35', '4234776890', 'mmaso.laba@solvd.com','4000.0', '18481'),
('4','Sofia', 'Mist', '29', '6237487899', 'smist.laba@solvd.com', '3200.0', '18482');*/

/*INSERT INTO offices (idOffices, name_offices, department) VALUES 
('18479','Monterrey', 'sellers'),
('18480','Mexico City', 'IT'), 
('18481','Tabasco', 'IT'),
('18482','Mexico City', 'Accounting and Administration');*/

/*INSERT INTO inventory (idInventory, stock_inventory, date_adquisition_inventory) VALUES 
('3400', '987', '2001-01-20'),
('3401', '1020','2006-01-20');*/

/*INSERT INTO categories (idCategories, name_categories, description_categories) VALUES 
('1','Gold filled', 'Charms, Chains, Bracelets'),
('2','Natural beads', 'Agates, Onyxes, Jades'),
('3','Crystal','');*/

/*INSERT INTO suppliers (idSuppliers, company_name_suppliers, email_suppliers, phone_suppliers, contact_suppliers) VALUES
('302762', 'Crystal & Beads', 'sales@crystalbeads.com', '8907657789', 'Samantha James'),
('302763', 'Beadsmith', 'hello@beadsmith.com', '7907657789', 'Jhon Smith'),
('302764', 'Gold Fantasies', 'sales@goldfantaies.com', '4907657789', 'Tim Mathew');*/

/*INSERT INTO products (idProducts, name_products, stock_inventory, price_sell_products, price_buy_products, Suppliers_idSuppliers, 
					  Categories_idCategories, Inventory_idInventory) VALUES 
('987504','Beads 8mm', '987', '2', '0.5', '302762','2', '3400'),
('987505','Beads 6mm', '1020', '1.5', '0.30', '302762','2', '3401');*/

/*INSERT INTO delivery (idDelivery, id_tracker_delivery) VALUES 
('202020', 'CDM170005'),
('202021', 'TAB270895'),
('202022', 'TAB270896'),
('202023', 'QUE2450800'),
('202024', 'MONT681192'),
('202025', 'MONT771890');*/

/*INSERT INTO orders (idOrders, amount_orders, date_orders, Clients_idClients, Employees_idEmployees, Delivery_idDelivery) VALUES 
('6570','265.5', '2023-01-04', '1', '1', '202020'),
('6571','105.0', '2023-01-02', '1', '1', '202021'),
('6572','300.0', '2023-01-11', '2', '1', '202022'),
('6573','94.5', '2023-01-16', '1', '3', '202023'),
('6574','15.5', '2023-01-12', '2', '3', '202024'),
('6575','1090.0', '2023-01-08', '3', '3', '202025');*/

#-------------------------------- 10 STATEMENTS OF UPDATE ---------------------------------

/*UPDATE clients SET age_clients = '59' WHERE idUser = '3';
UPDATE employees SET salary_employees = '1700' WHERE idUser = '1';
UPDATE offices SET department = 'sellers' WHERE idOffices = '18480';
UPDATE inventory SET date_adquisition_inventory = '2023-01-01' WHERE idInventory = '3400';
UPDATE inventory SET date_adquisition_inventory = '2023-01-06' WHERE idInventory = '3401';
UPDATE suppliers SET phone_suppliers = '8976334590' WHERE idSuppliers = '302763';
UPDATE employees SET idEmployees = '2' WHERE idEmployees = '3'; 
UPDATE employees SET idEmployees = '3' WHERE idEmployees = '4'; 
UPDATE products SET stock_inventory = '1000' WHERE idProducts = '987505';
UPDATE inventory SET stock_inventory = '1000' WHERE idInventory = '3401';*/

#-------------------------------- 10 STATEMENTS OF INSERTION ---------------------------------

/*DELETE FROM categories WHERE idCategories = '3';
DELETE FROM employees WHERE idUser = '2';
DELETE FROM offices WHERE idOffices = '18480';
DELETE FROM delivery WHERE idDelivery = '202022';
DELETE FROM delivery WHERE idDelivery = '202024' OR idDelivery = '202020';
DELETE FROM orders WHERE idOrders = 6570;
DELETE FROM orders WHERE idOrders = 6572;
DELETE FROM orders WHERE idOrders = 6574;
DELETE FROM clients WHERE idClients = 4;*/

#-------------------------------- 5 ALTER TABLE ---------------------------------
/*ALTER TABLE orders CHANGE COLUMN Clients_idClients Client_idClient INT;
ALTER TABLE orders CHANGE COLUMN Employees_idEmployees Employee_idEmployee INT;
ALTER TABLE payments CHANGE COLUMN Orders_idOrders Order_idOrder INT;
ALTER TABLE offices ADD COLUMN manager VARCHAR(45);
ALTER TABLE delivery ADD COLUMN date_registered DATE;
ALTER TABLE orders CHANGE COLUMN Clients_idClients idClients INT;
ALTER TABLE employees CHANGE COLUMN Offices_idOffices idOffices INT;
ALTER TABLE payments CHANGE COLUMN Orders_idOrders idOrders INT; 
ALTER TABLE orders CHANGE COLUMN Delivery_idDelivery idDelivery INT;
ALTER TABLE delivery_has_shippers CHANGE COLUMN Delivery_idtable1 idDelivery INT;
ALTER TABLE delivery_has_shippers CHANGE COLUMN Shippers_idShippers idShippers INT;
ALTER TABLE detail_orders CHANGE COLUMN Orders_idOrders idOrders INT;
ALTER TABLE detail_orders CHANGE COLUMN Products_idProducts1 idProducts INT;
ALTER TABLE products CHANGE COLUMN Suppliers_idSuppliers idSuppliers INT;
ALTER TABLE products CHANGE COLUMN Categories_idCategories idCategories INT;
ALTER TABLE products CHANGE COLUMN Inventory_idInventory idInventory INT;*/

#-------------------------------- 1 BIG STATEMENT TO JOIN ALL TABLES IN THE DB AND 5  STATEMENTS INNER ---------------------------------
/*SELECT clients.name_clients, 
	   clients.last_name_clients,
       clients.phone_clients,
       employees.name_employees,
       employees.last_name_employees,
       offices.department,
       orders.date_orders,
       payments.amount_payments,
       delivery.id_tracker_delivery,
       delivery_has_shippers.date_creation,
	   shippers.company_name_shippers,
	   detail_orders.idOrders,
	   products.name_products,
       categories.name_categories,
       inventory.idInventory,
       suppliers.idSuppliers
       
FROM clients 
	INNER JOIN orders
ON clients.idClients = orders.idClients
	INNER JOIN payments
ON orders.idOrders = payments.idOrders
	INNER JOIN employees
ON orders.idEmployees = employees.idEmployees
	INNER JOIN offices
ON employees.idOffices = offices.idOffices
	INNER JOIN delivery
ON orders.idDelivery = delivery.idDelivery
	INNER JOIN delivery_has_shippers
ON delivery.idDelivery = delivery_has_shippers.idDelivery 
	INNER JOIN shippers
ON delivery_has_shippers.idShippers = shippers.idShippers
	INNER JOIN detail_orders
ON orders.idOrders = detail_orders.idOrders
	INNER JOIN products
ON detail_orders.idProducts = products.idProducts
	INNER JOIN categories
ON products.idCategories = categories.idCategories
	INNER JOIN inventory
ON products.idInventory = inventory.idInventory
	INNER JOIN suppliers
ON products.idSuppliers = suppliers.idSuppliers
    */

#-------------------------------- 5  STATEMENTS WITH LEFT, RIGHT, INNER, OUTER JOINS ---------------------------------

/*SELECT * FROM clients LEFT JOIN orders ON clients.idClients = orders.idClients
SELECT * FROM employees LEFT JOIN orders ON employees.idEmployees = orders.idEmployees
SELECT * FROM orders LEFT JOIN payments ON orders.idOrders = payments.idOrders
SELECT * FROM orders LEFT JOIN delivery ON orders.idDelivery = delivery.idDelivery
SELECT * FROM delivery LEFT JOIN delivery_has_shippers ON delivery.idDelivery = delivery_has_shippers.idDelivery*/

/*SELECT * FROM clients RIGHT JOIN orders ON clients.idClients = orders.idClients
SELECT * FROM employees RIGHT JOIN orders ON employees.idEmployees = orders.idEmployees
SELECT * FROM orders RIGHT JOIN payments ON orders.idOrders = payments.idOrders
SELECT * FROM orders RIGHT JOIN delivery ON orders.idDelivery = delivery.idDelivery
SELECT * FROM delivery RIGHT JOIN delivery_has_shippers ON delivery.idDelivery = delivery_has_shippers.idDelivery*/

/*SELECT * FROM orders CROSS JOIN clients ON orders.idClients = clients.idClients
SELECT * FROM orders CROSS JOIN employees ON orders.idEmployees = employees.idEmployees
SELECT * FROM orders CROSS JOIN payments ON orders.idOrders = payments.idOrders
SELECT * FROM products CROSS JOIN categories ON products.idCategories = categories.idCategories
SELECT * FROM products CROSS JOIN inventory ON products.idInventory = inventory.idInventory*/

#-------------------------------- 7  STATEMENTS WITH AGGREGATE FUNCTIONS AND GROUP BY AND WITHOUT HAVING -------------------------------

/*SELECT idClients, COUNT(idOrders) FROM orders GROUP BY idClients;
SELECT name_employees, last_name_employees, age_employees, AVG(salary_employees) FROM employees GROUP BY idOffices;
SELECT orders.idOrders, employees.name_employees, MIN(amount_orders) FROM orders INNER JOIN employees ON employees.idEmployees = orders.idEmployees GROUP BY name_employees;
SELECT orders.idOrders, clients.idClients, clients.name_clients, MAX(amount_orders) FROM orders INNER JOIN clients ON clients.idClients = orders.idClients GROUP BY name_clients ORDER BY amount_orders DESC;
SELECT offices.name_offices, employees.name_employees, offices.department, AVG(salary_employees) FROM employees INNER JOIN offices ON offices.idOffices = employees.idOffices GROUP BY salary_employees ORDER BY salary_employees ASC;
SELECT products.name_products, categories.name_categories, products.stock_inventory, MAX(stock_inventory) FROM products INNER JOIN categories ON categories.idCategories = products.idCategories GROUP BY name_products;
SELECT products.name_products, products.stock_inventory, suppliers.company_name_suppliers, MIN(products.stock_inventory) FROM products INNER JOIN suppliers ON suppliers.idSuppliers = products.idSuppliers GROUP BY company_name_suppliers ORDER BY stock_inventory ASC;*/

#-------------------------------- 7  STATEMENTS WITH AGGREGATE FUNCTIONS AND GROUP BY AND WITHO HAVING ---------------------------------

/*SELECT idClients, COUNT(idOrders) FROM orders GROUP BY idClients HAVING AVG(amount_orders) > 200;
SELECT name_employees, last_name_employees, age_employees, AVG(salary_employees) FROM employees GROUP BY idOffices HAVING AVG(age_employees) > 24;
SELECT orders.idOrders, employees.name_employees, MAX(amount_orders) FROM orders INNER JOIN employees ON employees.idEmployees = orders.idEmployees GROUP BY name_employees HAVING COUNT(idClients) > 1 ;
SELECT orders.idOrders, clients.idClients, clients.name_clients, MAX(amount_orders) FROM orders INNER JOIN clients ON clients.idClients = orders.idClients GROUP BY name_clients HAVING COUNT(idOrders) >= 2;
SELECT offices.name_offices, employees.name_employees, offices.department, AVG(salary_employees) FROM employees INNER JOIN offices ON offices.idOffices = employees.idOffices GROUP BY salary_employees HAVING MIN(salary_employees) >=3500;
SELECT products.name_products, categories.name_categories, products.stock_inventory, MAX(stock_inventory) FROM products INNER JOIN categories ON categories.idCategories = products.idCategories GROUP BY name_products HAVING MIN(price_sell_products) < 2;
SELECT products.name_products, products.price_buy_products, suppliers.company_name_suppliers, suppliers.phone_suppliers, MAX(price_sell_products) FROM products INNER JOIN suppliers ON suppliers.idSuppliers = products.idSuppliers GROUP BY name_products HAVING MIN(price_buy_products) < 0.5;*/
