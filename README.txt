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




