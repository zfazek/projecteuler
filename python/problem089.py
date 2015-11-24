#!/usr/bin/env python

nums = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
vals = {'I' : 1,
        'V' : 5,
        'X' : 10,
        'L' : 50,
        'C' : 100,
        'D' : 500,
        'M' : 1000
}

milla = {0 : '',
     1 : 'M',
     2 : 'MM',
     3 : 'MMM',
     4 : 'MMMM'
}

kilo = {0 : '',
     1 : 'C',
     2 : 'CC',
     3 : 'CCC',
     4 : 'CD',
     5 : 'D',
     6 : 'DC',
     7 : 'DCC',
     8 : 'DCCC',
     9 : 'CM'
     }

deci = {0 : '',
     1 : 'X',
     2 : 'XX',
     3 : 'XXX',
     4 : 'XL',
     5 : 'L',
     6 : 'LX',
     7 : 'LXX',
     8 : 'LXXX',
     9 : 'XC'
     }

one = {0 : '',
     1 : 'I',
     2 : 'II',
     3 : 'III',
     4 : 'IV',
     5 : 'V',
     6 : 'VI',
     7 : 'VII',
     8 : 'VIII',
     9 : 'IX'
     }



def convertRomanToLatin(roman):
    i = 0
    result = 0
    prevChar = ''
    while i < len(roman):
        currentChar = roman[i]
        if i == 0:
            tempResult = vals[currentChar]
        else:
            if currentChar == prevChar:
                tempResult += vals[currentChar]
            elif nums.index(currentChar) > nums.index(prevChar):
                result += tempResult
                tempResult = vals[currentChar]
            elif nums.index(currentChar) < nums.index(prevChar):
                tempResult = vals[currentChar] - tempResult
                
        prevChar = currentChar
        if i == len(roman) - 1:
            result += tempResult
        i += 1
    #print roman, result
    return result

def convertLatinToRoman(latin):
    m = latin / 1000
    k = latin % 1000 / 100
    d = (latin - m * 1000 - k * 100) / 10
    o = latin - m * 1000 - k * 100 - d * 10
    res = milla[m] + kilo[k] + deci[d] + one[o]
    #print latin, res
    return res

def testConvertRomanToLatin():
    assert 1 == convertRomanToLatin('I')
    assert 5 == convertRomanToLatin('V')
    assert 10 == convertRomanToLatin('X')
    assert 50 == convertRomanToLatin('L')
    assert 100 == convertRomanToLatin('C')
    assert 500 == convertRomanToLatin('D')
    assert 1000 == convertRomanToLatin('M')
    assert 2 == convertRomanToLatin('II')
    assert 15 == convertRomanToLatin('VVV')
    assert 6 == convertRomanToLatin('VI')
    assert 3200 == convertRomanToLatin('MMMCC')
    assert 1666 == convertRomanToLatin('MDCLXVI')
    assert 4 == convertRomanToLatin('IV')
    assert 920 == convertRomanToLatin('CMXX')
    assert 820 == convertRomanToLatin('CCMXX')

def testConvertLatinToRoman():
    assert 'I' == convertLatinToRoman(1)
    assert 'MCMLXXI' == convertLatinToRoman(1971)
    assert 'MMMMDCLXXII' == convertLatinToRoman(4672)


testConvertRomanToLatin()
testConvertLatinToRoman()


sum = 0
file = open("roman.txt")
for line in file:
    l = line.rstrip("\n").split(" ")[0]
    latin = convertRomanToLatin(l)
    roman = convertLatinToRoman(latin)
    if l and roman:
        diff = len(l) - len(roman)
        if diff > 0:
            #print l, roman, len(l) - len(roman)
            sum += diff
    else:
        print "ERROR", l
print sum
 
