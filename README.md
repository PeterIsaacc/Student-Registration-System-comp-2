# Cloud Computing Assignment: Student Registration System

This repository contains the second component of a software application for student registration, which provides statistics related to student registration. It works in conjunction with the first component, which handles the student registration process. The application is designed using containerization concepts and consists of two main components.

## Components

### 2. Statistics Component

This component repository contains the code for the second component of the student registration system. It provides the following functionalities:

1. **Number of Users**: Displays the total number of registered students.

2. **Number of Students per Course**: Shows the count of students registered in each course.

3. **List Batch Files**: Lists all batch files located in the same path as mentioned in Requirement #2 of the first component.

   Technical Details:
   - The path `/app/data/batch/` should be correctly mounted to a specific folder.
   - The eligibility criteria for batch files are the same as mentioned in the first component.

After running the second component, the following information will be shown:
```
Number of users: 2
Number of students registered in AI course: 2
Number of students registered in Math course: 1
Number of students registered in Prog course: 1
```
*Note: In order to access the first component repository, please [visit](https://github.com/PeterIsaacc/Student-Registration-System-comp-1).*
---
*Note: Make sure you have the first component up and running before using the second component to retrieve statistics.*
