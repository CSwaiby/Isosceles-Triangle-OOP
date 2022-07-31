### Creating 2D isosceles triangle objects using Java  
  
This was a small university project to determine if we have an understanding over OOP.  
  
The isoceles triangle objet can be created through its base and leg and a 2D principle vertex or through a previously created isoscelesTriangle object. By default, if no arguments were assigned to the constructor, then it will have the origin as the principle vertex and both the leg and base will be equal to 1.  
  
Additional functions were added to enrich the project:  
  
**height()**: Instance method used to Check the height of the isoscelesTriangle object (to be used in other methods).  
**perimeter()**: Instance method used to Check the perimeter of the isoscelesTriangle object.  
**surfaceArea()**: Instance method used to Check the surface area of the isoscelesTriangle object.  
**move(double dx , double dy)**: Instance method to move the triangle depending on a vector.  
**moveTo(double newX , double newY)**: Instance method to completely move the triangle depending on new coordinates for the principal vertex.  
**distanceBetween(isoscelesTriangle t, isoscelesTriangle q)**: Class method to find the distance between two isoscelesTriangle objects.  
**compareSize(isoscelesTriangle t, isoscelesTriangle q)**: Class method to compare the sizes of two isoscelestriangle objects depending on their surface area.  
Additional methods were added to complement and complete the project: getters and setters, toString and equals methods, getting coordinates of the other vertices and center of gravity (COG) of the isoscelesTriangle object and printing the coordinate of all vertices, finnaly a main method to test our code.  
  
Date of creation: *21/02/2021*  
Project done by **CSwaiby** using Eclipse IDE. 
  