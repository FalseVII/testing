████████╗███████╗░██████╗████████╗██╗███╗░░██╗░██████╗░
╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝██║████╗░██║██╔════╝░
░░░██║░░░█████╗░░╚█████╗░░░░██║░░░██║██╔██╗██║██║░░██╗░
░░░██║░░░██╔══╝░░░╚═══██╗░░░██║░░░██║██║╚████║██║░░╚██╗
░░░██║░░░███████╗██████╔╝░░░██║░░░██║██║░╚███║╚██████╔╝
░░░╚═╝░░░╚══════╝╚═════╝░░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░


Bugs found so far:

Double print goodbye if player one wins.\
Does not check player one hitting an exact 20 for draw, counts it as a draw if over 20.\
Does not roll dice for player two, reuses values from roll one.\
Rounds start at two.\
Die rolls can hit a 0; should be 1-6.\
Repeats Dice 1 twice for player one.\

Application does not exit on completion.(?)\


<h3>Unit Tests:</h3>

Unit testing is intended to ensure that the\
code written works as intended before it is\
integrated with other units\
Verifies that all the code written can be\
executed\
Usually supported by a test framework\
(jUnit in this case)\
Can use test driven approach\
Usually performed by the developer\


<h3>Integration tests:</h3>

Integration is building something from\
smaller units of software\
Purpose of integration testing is to expose\
defects in the interfaces and in the\
interactions between components\
An integration strategy is required:\
    - Bottom up\
    Sometimes necessary to replace\
    components with a stub ( a passive skeletal\
    implementation of a component)\

<h3>Manual Tests:</h3>

Manual testing is the process of manually executing a\
test case to verify that the software works as expected.\
Manual testing is the most basic form of testing.\


