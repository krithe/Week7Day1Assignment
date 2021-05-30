Feature: Login to the Leaftaps Application to Create Lead

Scenario Outline: Create New Lead with mandatory fields


And Enter the username 'DemoSalesManager'
And Enter the password 'crmsfa'
And Click Login button
And Click CRMSFA
And Click Leads
And Click Create Leads 
And Enter Company Name as <CompanyName>
And Enter First Name as <FirstName>
And Enter Last Name as <LastName>
And Click Submit
Then Verify if New lead is created

Examples:

|companyname|Firstname|Lastname|
|TestLeaf|Krithi|M|

