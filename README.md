# P2-ScapeGoats-BackEnd

# Reality Escape Cards (Tarot Cards) - Proposal

## Story

Life got you down? Are you lost? Not sure what move to make next? With a Reality Escape Cards reading you can have access to a Psychic that will tell you your future and provide answers to your most pressing life questions, all from the comfort of your own home with no appointment needed. With Reality Escape Cards you are just one mouse click away from learning more about your career, love life, pet's happiness, or anything else you may be in search of answers for. Should you sell everything and move into the woods? Buy a house you can't afford? A psychic can make all these decisions easier.
With Reality Escape Cards, you can pull up previous readings to compare and make current choices. Consultants are always online to help you cope with your impending doom or prosperity.


## Team Members

* Melissa Clark (Lead - Backend)
* Jon mikael (Frontend)
* Delane Green (Frontend)
* David Burrington (Frontend)
* John Nguyen (Backend)

## External API

* https://rws-cards-api.herokuapp.com/

## MVP

* Users able to create an account and sign up - stored in the database
* User can select categories to receive readings based on 
* Tarot Cards give readings based on category selected
* Admin can delete and add users and consultants
* Admin can edit consultants
* Users can view their reading history
* Database stores users reading history
* Admin can reset a password
* Users have options to save reading or hire consultant (paid services) (user can click one or more option - NOT either or)
* User can Log in with created credentials

## Suggested Bonus Features

* Users can share their cards on Social Media
* Users can hire consultants
* Save info of users hiring consultants
* Reviews of Consultants
* User can view reviews of consultants

## Use Case

![2022-09-21 (3)](https://user-images.githubusercontent.com/107011138/192028714-dd76c039-6d94-4fdb-a259-625d8a759780.png)

## ERD

![image](https://user-images.githubusercontent.com/37430000/189683846-a3a92923-5265-4183-a82c-1b860bf7f2fe.png)


### Usage

Upon visiting our site, a user will be prompted to either sign up or login. A user can sign up by providing an email and creating a username and password. Once the account is created they will be able to login with those credentials. Once logged in a user can choose to receive a tarot reading by selecting a category that they would like to receive a reading for. The user will then receive three tarot cards as their reading which possess various meanings. The user can then either choose to save or discard their reading. If saved the user can then view that reading in their reading history where all saved readings are stored. Users can also request a consultation with a third-party consultant if they wish to discuss their reading.

### Project Management

* Agile Methodology
* Trello

### Technology

* Written in Java 8.
* SpringBoot
* External API (Tarot Card Reader API)
* Maven
* PostgreSQL
* Tomcat
* Amazon Elastic Beanstock
* Amazon Managed Relational Database Services (RDS)
* Postman
* Docker
* Java Web Tokens
* Junit
* Mockito
* Lucid Charts

### Roles

* User
* Admin
* Consulting - soothesayer

## Phases

### Pre-phase (September 9, 2022)

* Present Proposal

### Phase 1 (9/9 - 9/12)

-	Create ERD
-	Set up database in DBeaver
-	Create rough design for frontend
-	Select an external API
-	Create roles and category models and controllers for backend use

### Phase 2 (9/13 - 9/16)

-	Create all object models in the backend
-	Create landing page
-	Create a login and sign-up page
-	Create webpage for the admin users on the backend
-	Create remaining pages (history, settings, tarot reading)

### Phase 3 (9/17 - 9/21)

-	Achieve 80% test coverage on the backend
-	Select and implement a CSS style
-	Set up ec2 instance 
-	Have data from the frontend save to the database
-	Get the tarot card images to show on reading page
-	Get authentication token from headers with axios
-	Clean up code

### Final (9/21 - 9/25)

-	Finalize code, code freeze 9/22
-	Rehearse for presentation

## Contributors

* Melissa Clark
* Jon Mikael Transfiguracion
* David Burrington
* Chuong Nguyen
* Delane Green
