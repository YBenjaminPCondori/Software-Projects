""" Importing Regex Library """

import re



""" Read (r) file of preproinsultin TXT dataset """

with open('preproinsulin-seq.txt', 'r') as file:
    raw_data = file.read()


""" Remove 'ORIGIN', numbers, slashes, whitespace, 
    newlines, and carriage returns                    
"""

cleaned_data = re.sub(r'ORIGIN|\d+|//|\s+', '', raw_data, flags=re.IGNORECASE).lower()


""" Save the fully cleaned sequence into a NEW
    Cleaned File                               
"""

with open('preproinsulin-seq-clean.txt', 'w') as file:
    file.write(cleaned_data)


""" Confirm that your file has 110 characters of 
    lowercase letters, 
    which represent the amino acids in the sequence of 
    human preproinsulin. 
"""

""" USING Python BASH Terminal: 1. pwd
                                2. wc -m preproinsulin.txt 
"""




""" In lsinsulin-seq-clean.txt, save amino acids 1–24. """
   
lsInsulin = cleaned_data[0:24]


""" Write (w) New File isInsulin SEQ CLEAN TXT with (1-25) characters """

with open('lsInsulin-seq-clean.txt', 'w') as file:
    file.write(lsInsulin)
    
""" Verify that your file has 24 characters ONLY.
    Python BASH Termina;: wc -m isinsulin-seq-clean.txt 
"""

    
    
    
""" In binsulin-seq-clean.txt, save amino acids (25–55). """
    
bInsulin = cleaned_data[24:54]


""" Write (w) New File isInsulin SEQ CLEAN TXT with (25-54) character """

with open('bInsulin-seq-clean.txt', 'w') as file:
    file.write(bInsulin)
    
""" Verify that your file has 30 characters. 
    
    Python BASH Termina;: wc -m binsulin-seq-clean.txt 
"""
    
    
    
    
""" In cinsulin-seq-clean.txt, save amino acids 55–89. """

cInsulin = cleaned_data[54:88]


""" Write (w) New File cInsulin SEQ CLEAN TXT with (55 - 89) characters """

with open('cInsulin-seq-clean.txt', 'w') as file:
    file.write(cInsulin)


""" Verify that your file has 21 characters. 
    
    Python BASH Termina;: wc -m cinsulin-seq-clean.txt
"""


    
    
""" In cinsulin-seq-clean.txt, save amino acids 88 - 109. """

aInsulin = cleaned_data[89:110]


""" Write (w) New File cInsulin SEQ CLEAN TXT with (55 - 89) characters """

with open('aInsulin-seq-clean.txt', 'w') as file:
    file.write(aInsulin)
    

""" Verify that your file has 35 characters. 
    
    Python BASH Termina;: wc -m ainsulin-seq-clean.txt 
"""
    

print("Operations, cleaned up, Cleaned sequence and extracted segments saved.")
