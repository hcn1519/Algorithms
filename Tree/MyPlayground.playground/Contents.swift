//: Playground - noun: a place where people can play

import UIKit

var str = "Hello World"

//print(str[str.startIndex])
//print(str[str.index(before: str.endIndex)])
//
//print(str.startIndex)
//print(str.endIndex)

print(str[str.index(str.startIndex, offsetBy: 6)])

print(str[str.index(str.index(after: str.startIndex), offsetBy: 6)])

print(str[str.index(str.endIndex, offsetBy: -1)])
print(str[str.index(str.endIndex, offsetBy: -3)])
//
for i in str.characters.indices {
    print(i)
}

for char in str.characters {
    print(char)
}


for (index, value) in str.characters.enumerated() {
    print("index: \(index), value : \(value)")
    print(Int(index))
}

str.insert("a", at: str.startIndex)

str.remove(at: str.startIndex)

let range = "World"

for i in range.characters {
    print(i)
}


var s = "한글"

if s[s.startIndex] == "한" {
    print("앞 글자가 한")
}
if s.hasSuffix("한글") {
    print("뒷 쪽이 한글")
}


