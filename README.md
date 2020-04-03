SDE Challenge:

Solution 1: Calculate Moving average of the last N elements


To meet our requirements and maintain optimal performance, the underlying data structure being used here is an LinkedList. We could have used ArrayList as well but because we are very often adding elements into the list, so its better to go with the LinkedList rather than ArrayList due to the time insertion time complexity of LinkedList. For insertion, LinkedList has time complexity of O(1) whereas for ArrayList it is O(n).

Also, deletions are faster in case of LinkedList as compared to the ArrayList. For frequent additions and deletions, LinkedList is much better than ArrayList.

When the list grows, all the elements in the ArrayList need to be copied into a bigger sized location as it is backed by an array internally. This is not the case in the LinkedList as it maintains pointers.

To increase the performance further and make sure we do not put validation checks every time, the windowSize validation has been put inside the constructor itself. This wont allow us to instantiate the implementation class in case the value of the windowSize is not correct. Also, we need not put this check later on.


The solution consists of 1 interface and 3 classes. 

The interface MovingAverage contains declaration of three methods:
	- addElement: to add element to the data structure
	- calculateMovingAverage: to calculate the moving average of the last N elements at any give point of time
	- getElements: get all the elements in the data structure

The interface has been designed to be a generic interface so that it can work with any type of data. The implementing class can specify the type it wants 
to deal with.
	
The class MovingAverageImpl implements the MovingAverage interface and provides definition for all the methods. This class handles all the necessary validations
for the various inputs to make sure our average is consistent with the input. The necessary documentation has also been added to the code to provide a more clear
understanding. On instantiation, this class validates the input windowSize value for correct value and throws the necessary exception otherwise. It also initializes the other member variables. Whenever an element is added, it is validated for correct input and added to the underlying data structure. At any given point of time, the sum of the last N values are always present in the "sum" which eases the average calculation part later on. On addition of a new element, if the size of the data structure exceeds N, necessary coding has been done to make sure it always accommodates the latest value and removes the first one to maintain the sum of last N values.

The calculateMovingAverage method is used to find the average of the last N elements using a simple divide operation as the sum already contains the addition of last N elements.

The getElements method is used to return all the elements in the underlying data structure.

The class CalculateMovingAverage is the main class driving the entire system. It is responsible for instantiating the MovingAverageImpl class, initializing the 
windowSize variable and depicting the working of addElement, calculateMovingAverage and getElements methods of the implementation class.

The class CalculateMovingAverageTest is a JUnit class that contains several test cases to validate the corner cases and make sure our system does not break when 
supplied with extreme values.





Solution 2: 

1. We can use Kafka as a distributed, multi-tenant solution to store, process and manage high volumes of data. Data can be fully replicated and it is fault tolerant. It can be used to store billions of records and also as a stream processing tool with low latency. 

2. Microservices: Use Spring Boot with clusters of microservices and zookeeper for service discovery. Using microservices, individual services can be scaled easily without impacting other services. 

3. Spring boot provides the inbuilt monitoring tool i.e. Spring Boot Actuator that can provide a lot of metrics for your services. These can be easily configured and can be shared with the customers.

4. Load Balancers along with sticky sessions: Depending on the complexity of your site, you could either have FrontEnd servers that act as your load balancers and application servers or a more complex setup where the amount of incoming traffic warrants the use of dedicated load balancers. We can use Spring Cloud that has been integrated with Netflix Eureka for Service Registry and with Hystrix for circuit breaking.

5. We need to use the master-slave model of MySQL to replicate the live data. This will help to recover data in case of failures. The recommended strategy for maintaining data integrity is creating a full backup of the primary database then incrementally testing the source server for data corruptions. Creating full backups is at the forefront of recovering from catastrophic system failure.

6. We must configure a proper alert system, monitoring and admin services to report in case of bugs or issues. Plan for failure: Despite the fact that applying the best practices for high availability is essentially planning for failure; there are other actions an organization can take to increase their preparedness in the event of a system failure leading to downtime.