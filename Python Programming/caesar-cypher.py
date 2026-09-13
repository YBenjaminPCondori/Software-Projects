""" getDoubleAlphabet function with alpabet argument, returns sum operation
    (doubleAlphabet)
"""

def getDoubleAlphabet(alphabet):
    doubleAlphabet = alphabet + alphabet
    return doubleAlphabet
    
    
""" getMessage function with no argument, returns an output on the console,
    prompting the user for INPUT. Return StringtoEncrypt
"""

def getMessage():
    stringToEncrypt = input("Please enter a message to encrypt: ")
    return stringToEncrypt
    

""" getCipherKey function with no arguemnt, reutrns an ouput on the console,
    prompting the user for INPUT. Returns Shift Amount
"""    
    
def getCipherKey():
    shiftAmount = input( "Please enter a key (whole number from 1-25): ")
    return shiftAmount
    
    
"""
    encryptMessage function with no "message", "cipherkey". and "alphabet"
     arguments, FOR LOOP, with IF LOOP nested inside.
"""

def encryptMessage(message, cipherKey, alphabet):
    
    encryptedMessage = ""
    uppercaseMessage = ""
    uppercaseMessage = message.upper()
    
    for currentCharacter in uppercaseMessage:
      
        
# Position variables = the position of the Current Character - FIND 
       
        position = alphabet.find(currentCharacter)
        

# new Position variable = the new position of the current character - WRITE 
        
        newPosition = position + int(cipherKey)
        

        if currentCharacter in alphabet:
            
# If current letter is not in the alphabet, append the current letter.
            encryptedMessage = encryptedMessage + alphabet[newPosition]
        else:
            
            
# Return the encrypted message after exhausting all the letters in the message.
            encryptedMessage = encryptedMessage + currentCharacter
            
# Return the encrypted message after exhausting all the letters in the message.
    return encryptedMessage
    
def decryptMessage(message, cipherKey, alphabet):
    decryptKey = -1 * int(cipherKey)
    return encryptMessage(message, decryptKey, alphabet)

    
def runCaesarCipherProgram():

    myAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    print(f'Alphabet: {myAlphabet}')
    
    """ Define a string variable to contain the English alphabet. """


    myAlphabet2 = getDoubleAlphabet(myAlphabet)
    print(f'Alphabet2: {myAlphabet2}')
    
    """ To be able to shift letters, double your alphabet string. """


    myMessage = getMessage()
    print(myMessage)
    
    """ Get a message to encrypt from the user. """


    myCipherKey = getCipherKey()
    print(myCipherKey)
    
    """ Get a cipher key from the user. """


    myEncryptedMessage = encryptMessage(myMessage, myCipherKey, myAlphabet2)
    print(f'Encrypted Message: {myEncryptedMessage}')
    
    """ Encrypt the message. """


    myDecryptedMessage = decryptMessage(myEncryptedMessage, myCipherKey, myAlphabet2)
    print(f'Decypted Message: {myDecryptedMessage}')
    
    """ Decrypt the message """
    
    
runCaesarCipherProgram()