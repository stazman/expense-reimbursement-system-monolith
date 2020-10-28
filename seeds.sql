INSERT INTO ers_reimb VALUES (default, 134.56, '2016-06-22 19:10:25-07', '2016-06-22 18:10:26-07', 'Two nights, Antarctic Inn', 'This is your receipt', 1, 2, 1, 1)
INSERT INTO ers_reimb VALUES (default, 3120.32, '2016-06-22 19:10:25-07', '2016-06-22 18:10:26-07', 'Plane ticket, Antarctica', 'This is your receipt', 3, 4, 1, 2)
INSERT INTO ers_reimb VALUES (default, 78.48, '2016-06-22 19:10:25-07', '2016-06-22 18:10:26-07', 'Lunch with clients at the Penguin Lounge', 'This is your receipt', 1, 2, 2, 3)
INSERT INTO ers_reimb VALUES (default, 75.00, '2016-06-22 19:10:25-07', '2016-06-22 18:10:26-07', 'Ticket to Antarcticon business conference', 'This is your receipt', 3, 4, 3, 4)

INSERT INTO ers_reimb_type VALUES (default, 'Lodging');
INSERT INTO ers_reimb_type VALUES (default, 'Travel');
INSERT INTO ers_reimb_type VALUES (default, 'Food');
INSERT INTO ers_reimb_type VALUES (default, 'Other');

INSERT INTO ers_reimb_stat VALUES (default, 'Pending');
INSERT INTO ers_reimb_stat VALUES (default, 'Approved');
INSERT INTO ers_reimb_stat VALUES (default, 'Denied');

INSERT INTO ers_usrs VALUES (default, 'employeebob@gmail.com', 'Bobemployee$123', 'Bob', 'Bobberly', 'employeebob@gmail.com', 2);
INSERT INTO ers_usrs VALUES (default, 'managerbob@gmail.com', 'Bobmanager$123', 'Bob', 'Bobson', 'managerbobe@gmail.com', 1);
INSERT INTO ers_usrs VALUES (default, 'employeebill@gmail.com', 'Billemployee$123', 'Bill', 'Billington', 'employeebill@gmail.com', 2);
INSERT INTO ers_usrs VALUES (default, 'managerbill@gmail.com', 'Billmanager$123', 'Bill', 'Billarillo', 'managerbill@gmail.com', 1);

INSERT INTO ers_usr_roles VALUES (default, 'Manager');
INSERT INTO ers_usr_roles VALUES (default, 'Employee');