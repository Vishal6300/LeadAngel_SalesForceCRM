# LeadAngel_SalesForceCRM
Setup Steps:- 
1. Used: 
Java 17
Maven build
MySQL running on localhost:3306
2. ✅ Create MySQL Database
CREATE DATABASE lead_engine_db;

3. Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/lead_engine_db
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Settings
security.jwt.secret=....
security.jwt.token.expire.length=3600000

4. Architecture Diagram:
LeadAngel Spring Boot App    
                  |  (Microservice Backend Layer)  |
                  +---------------+---------------+
                                  |
     +----------------------------+----------------------------+
     |                            |                            |
     v                            v                            v
+------------+         +------------------+         +--------------------+
| RuleEngine |         |   CRMService     |         | JWT Auth (Filter)  |
+------------+         +------------------+         +--------------------+
     |                          |
     v                          v
+------------+         +---------------------+
| RoutingRule|         |  http://localhost:5000 |
+------------+         |   (LeadAngel CRM)     |
                       +---------------------+

5. Rule Engine Explanation:
Implemented using Spring Expression Language (SpEL).
Each rule contains a condition like:
country == 'US' && revenue > 500000RuleEngine evaluates each lead against rules sorted by priority.
The first matching rule determines which SalesRep is assigned.
Rules are stored in DB and fully dynamic.
🔁 CRM SimulationSimulated CRM lives at: http://localhost:5000/mock-crm/leads
The system:
Logs each lead assignment
Schedules a background task every 5 minutes to sync unsynced leads
Uses Spring's @Scheduled and @Async to sync data in the background.
✅Key Features :
✅ JWT-based secure APIs
✅ SpEL-powered rule engine
✅ Async lead processing
✅ Scheduled CRM sync
✅ Swagger API documentation
✅ Modular and testable Spring Boot design


![image](https://github.com/user-attachments/assets/a079a0bd-6df2-4d3f-8189-5b20b36b9a26)

