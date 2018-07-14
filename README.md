# Multi-Level-Market-Sale
This project contains basic design of sales person in multi level marketing chain.

* You will find an entity named as SalesPerson which is used to store the Distributors or sellers of Multi level marketing Chain.
  This entity has a foreign key reference to its own table to maintain the hirerachy.
  
* A Sales controller which contians a method goodsSold, takes sales person id and amount of sale as input 
  and update the balance of all the sales person in his chain.

