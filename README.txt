Testing Example Repository.


Bugs found so far:

Double print goodbye.
Does not check player one hitting an exact 20 for draw.
Does not roll dice for player two, reuses values from roll one.
Rounds start at two.
Die rolls can hit a 0; should be 1-6.
Repeats Dice 1 twice for player one.

Application does not exit on completion.(?)
Sometimes the same seed is used for a couple rolls in a row, always use SecureRandom instead of Math.random().


        Test Levels:

    Unit Tests:

Unit testing is intended to ensure that the
code written works as intended before it is
integrated with other units
Verifies that all the code written can be
executed
Usually supported by a test framework
(jUnit in this case)
Can use test driven approach
Usually performed by the developer


    Integration Tests:

Integration is building something from
smaller units of software
Purpose of integration testing is to expose
defects in the interfaces and in the
interactions between components
An integration strategy is required:
    - Top down
    Sometimes necessary to replace
    components with a stub ( a passive skeletal
    implementation of a component)

    Manual Tests:

Manual testing is the process of manually executing a
test case to verify that the software works as expected.
Manual testing is the most basic form of testing.


