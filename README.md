# Delivery-Products
Supermarket Management and Delivery Products (SMDP) is a web application that allows you to deliver products from different supermarkets at home.

How SMDP works? A set of supermarkets S1, S2, ... Sn belonging to the same subsidiary want to implement an online product order application to facilitate the task for their customers.
This Online Product Ordering System is a process in which you can order various products from these supermarkets using the Internet.
Each supermarket offers a list of products it sells and has a set of delivery men.
Each delivery person is affiliated to a single supermarket. At every moment he is either free (waiting for orders to be delivered) or busy (during the delivery of an order). He can consult the list of deliveries that are assigned to him, and confirm the deliveries made.
A customer consults the list of available products and orders a set of products specifying their quantities. He can specify or choose the date and time of delivery of his order. The customer is notified by SMS or Email of the availability of his order. The
system provides the amount of purchases and the cost of delivery. It is assumed that delivery costs are the same for all customers.
The system selects, according to the customer's address, the nearest supermarket and designates a free delivery person to deliver the order to the customer on the date indicated. The notified deliverer of the new delivery takes the ordered products and the corresponding invoice and delivers them to the customer at his place of residence.
Also, we need to specify that our system, search the supermarket that is close to the address of the visitor or client and if we don’t find some products we go for other supermarkets. The price of delivery changed when changing the distance.

Technologies used: For design pattern i used MVC (Model, Vue , Controller), for programming language i used Java/JEE with Hibernate Framework, to manipulate the data i used MySQL and in front end i used HTML5,CSS3&Bootstrap, JavaScript and frameworks of JS like JQuery and Ajax. Also, to show the results, i interacted with Maps API (JSON Data) and to perform the query of the Maps API i used Java.net and gson package to manipulate json data.

You can find how the project looks like in the UI file.
