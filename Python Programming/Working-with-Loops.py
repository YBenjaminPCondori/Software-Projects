"""Working with Loops"""

"""LOOPS: While"""

import random

number = random.randint(1,10)

isGuessRight = False

while isGuessRight != True:
    guess = input("Guess a single number from between 1 - 10")
    if int(guess) == number:
        print("You guessed {}. That is correct! You win!".format(guess))
        isGuessRight = True
    else:
        print("You guessed {}. Sorry, that isn’t it. Try again.".format(guess))