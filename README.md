████████╗███████╗░██████╗████████╗██╗███╗░░██╗░██████╗░
╚══██╔══╝██╔════╝██╔════╝╚══██╔══╝██║████╗░██║██╔════╝░
░░░██║░░░█████╗░░╚█████╗░░░░██║░░░██║██╔██╗██║██║░░██╗░
░░░██║░░░██╔══╝░░░╚═══██╗░░░██║░░░██║██║╚████║██║░░╚██╗
░░░██║░░░███████╗██████╔╝░░░██║░░░██║██║░╚███║╚██████╔╝
░░░╚═╝░░░╚══════╝╚═════╝░░░░╚═╝░░░╚═╝╚═╝░░╚══╝░╚═════╝░


Bugs found so far:
<ul>
<li>Double print goodbye if player one wins.</li>
<li>Does not check player one hitting an exact 20 for draw, counts it as a draw if over 20.</li>
<li>Does not roll dice for player two, reuses values from roll one.</li>
<li>Rounds start at two.</li>
<li>Die rolls can hit a 0; should be 1-6.</li>
<li>Repeats Dice 1 twice String for player one.</li>
</ul>

![img.png](img.png)

<h3>Unit Tests:</h3>

Using the bottom up implementation testing method, \
the unit tests for classes deemed outside by the UML were written first\
classes that did not communicate with other classes were tested to ensure\
that the class was working as intended.

![img_3.png](img_3.png)

Once the smallest "units of software" were tested, then came\
the integration tests.

<h3>Integration tests:</h3>

Integration tests are implemented to classes that use other classes\
to ensure that the classes are working together as intended.\
This was done using the UML Diagram to determine which classes\
communicated with each other.

![img_1.png](img_1.png)

For example, unit tests were written for the Die class\
and integration tests were written for PairOfDice class\
since the PairOfDice class uses the Die class.

Since everything combined inside the Game class, the Game class\
was tested last with a stub to manipulate the values inside it for all\
three possible outcomes of the application.

The coverage report shows that all classes are tested\
and all methods are tested.

![img_2.png](img_2.png)

<h3>Manual Tests:</h3>

Once unit tests and integration tests were written, the manual tests\
were used, created from real world scenarios (user stories), to ensure that the\
program was working as intended.

    Test 01
    **Scenario**: Player one wins
    **Given**: The application is running
    **When**: I enter player one name "Vlad"
    **And**: I enter player two name "John"
    **And**: I enter "y" in response to "roll the dice"
    **And**: I enter player one rolls over "20"
    **And**: I enter player two roll under "19"
    **Then**: Player one wins

    Test 02
    **Scenario**: Player two wins
    **Given**: The application is running
    **When**: I enter player one name "Vlad"
    **And**: I enter player two name "John"
    **And**: I enter "y" in response to "roll the dice"
    **And**: I enter player one rolls under "19"
    **And**: I enter player two roll over "20"
    **Then**: Player two wins


    Test 03
    **Scenario**: Draw
    **Given**: The application is running
    **When**: I enter player one name "Vlad"
    **And**: I enter player two name "John"
    **And**: I enter "y" in response to "roll the dice"
    **And**: I enter player one rolls over "20"
    **And**: I enter player two roll over "20"
    **Then**: Draw

    Test 04
    **Scenario**: Not rolling dice.
    **Given**: The application is running
    **When**: I enter player one name "Vlad"
    **And**: I enter player two name "John"
    **And**: I enter "n" in response to "roll the dice"
    **Then**: "Goodbye" is printed



