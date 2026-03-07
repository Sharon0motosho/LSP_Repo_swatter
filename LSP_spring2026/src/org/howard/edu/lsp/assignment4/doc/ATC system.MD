#1
###CRC Card
Class: Aircraft

#####Responsibilities:

-Store aircraft ID and type

-Store flight data like altitude, speed, and position

-Return aircraft information when other parts of the system request it

#####Collaborators (if any):

-AircraftDatabase

-ConflictDetector

-GraphicsDisplay

#####Assumptions (if any):

-Each aircraft has a unique ID used to track it in the system.



#2

###CRC Card
Class: Transponder

#####Responsibilities:

-Broadcast aircraft type and flight data

-Send data packets to the ground station

-Continue sending data while the aircraft is in range

#####Collaborators (if any):

-ATCReceiver

#####Assumptions (if any):

-All aircraft in the system have a working transponder.


#3
###CRC Card
Class: ATCReceiver

#####Responsibilities:

-Receive packets from aircraft transponders

-Check if the packet was received correctly

-Send packet data to the packet processor

#####Collaborators (if any):

-Transponder

-PacketProcessor

#####Assumptions (if any):

-Some packets may be lost or corrupted during transmission.




#4
###CRC Card
Class: PacketProcessor

#####Responsibilities:

-Decode the packet format

-Extract aircraft type and flight data

-Send processed aircraft data to the aircraft database

#####Collaborators (if any):

-ATCReceiver

-AircraftDatabase

-Aircraft

#####Assumptions (if any):

-The system already knows the packet structure.



#5
###CRC Card
Class: AircraftDatabase

#####Responsibilities:

-Store aircraft information

-Update aircraft information when new data comes in

-Return aircraft data when the display or controller requests it


#####Collaborators (if any):

-PacketProcessor

-Aircraft

-GraphicsDisplay

-ControllerConsole

-ConflictDetector

#####Assumptions (if any):

-Only aircraft currently being tracked are stored.



#6

###CRC Card
Class: ConflictDetector

#####Responsibilities:

-Check aircraft positions and flight paths

-Detect potentially dangerous situations

-Send warnings when aircraft violate safety distances

#####Collaborators (if any):

-AircraftDatabase

-GraphicsDisplay

-ControllerConsole

#####Assumptions (if any):

-Safety distance rules are already defined.



#7
###CRC Card
Class: GraphicsDisplay

#####Responsibilities:

-Display aircraft positions on the controller screen

-Update the display every 10 seconds

-Highlight aircraft involved in dangerous situations

-Show aircraft details selected by the controller

#####Collaborators (if any):

-AircraftDatabase

-ConflictDetector

-ControllerConsole

#####Assumptions (if any):

-The display refreshes automatically every 10 seconds.



#8
###CRC Card
Class: ControllerConsole

#####Responsibilities:

-Allow the controller to select aircraft on the display

-Request aircraft information from the database

-Show detailed aircraft information to the controller

#####Collaborators (if any):

-AircraftDatabase

-GraphicsDisplay

#####Assumptions (if any):

-The controller queries aircraft using the aircraft ID.
