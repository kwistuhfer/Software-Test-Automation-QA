# CS 320: Software Test, Automation QA Portfolio

Christopher Olvera

## Contents
- `src/main/Contact.java` and `ContactService.java`: a contact object and a service that adds, updates, and deletes contacts by unique ID (project one)
- `src/test/ContactTest.java` and `ContactServiceTest.java`: JUnit 5 tests for both classes
- `Project_Two_Summary_and_Reflections.docx`: a report on my testing approach, the techniques I used and did not use, and the mindset of a software tester (project two)

Together these show my work writing unit tests that uncover errors, comparing testing approaches against requirements, and choosing testing strategies that fit them.

## Reflection

**How can I ensure that my code, program, or software is functional and secure?**
I start from the requirements and write tests for each rule: valid input, null, empty, too long, and exactly at the limit. For the phone number, 
which must be exactly ten digits, I tested nine digits, eleven digits, and a ten-character string containing a letter. That last test failed at first because my code 
only checked length, which showed me a real gap. I reran the full suite after every change to catch regressions, and I used coverage tools to find branches my tests never reached.

**How do I interpret user needs and incorporate them into a program?**
I treat the written requirements as the source of truth and turn each one into something testable, such as "ID no longer than 10 characters" becoming a pair of tests at ten and 
eleven characters. When a test failed, I went back to the requirement before deciding whether the test or the code was wrong. Feedback from my instructor worked like an outside 
review of those requirements. I also learned to ask what the user would expect to happen with unusual input, such as an empty field.

**How do I approach designing software?**
I keep each class focused on one job: Contact holds and validates data, and ContactService manages the collection. I put validation in one place, the setters, and had the 
constructor use them, so the rules cannot drift apart. When my single update method allowed a partly changed record, I replaced it with four methods that each change one field. 
Writing tests while designing exposed weak spots in the design, and I want to keep that habit.
