//
//  main.swift
//  BOJ_6378
//
//  Created by 홍창남 on 2017. 10. 20..
//  Copyright © 2017년 홍창남. All rights reserved.
//

import Foundation
struct ReadInput {

    private var currentIndex: Int = 0
    private var inputArray: [String] = []

    // 데이터를 배열로 변환
    public mutating func readLineToArray() -> [String] {

        guard let result = readLine() else {
            return []
        }

        return result.components(separatedBy: " ")
    }

    // 띄어쓰기 단위로 String 읽기
    public mutating func read() -> String {
        if inputArray.count == 0 {
            inputArray = self.readLineToArray()
        }
        let result = inputArray[inputArray.index(after: currentIndex-1)]
        currentIndex += 1

        if currentIndex == inputArray.count {
            self.inputArray.removeAll()
            self.currentIndex = 0
        }

        return result
    }

    // Int 데이터 읽기
    public mutating func readInt() -> Int {
        guard let result = Int(self.read()) else {
            fatalError("Int형 데이터가 아닙니다.")
        }

        return result
    }

    // Double 데이터 읽기
    public mutating func readDouble() -> Double {
        guard let result = Double(self.read()) else {
            fatalError("Double형 데이터가 아닙니다.")
        }

        return result
    }
}

func divideNumber(_ input: String) -> Int {

    var strArr: [String] = []
    for i in input {
        strArr.append(String(i))
    }
    var result = 0

    for i in strArr {
        result += Int(i)!
    }

    return result
}

func digitalRoot(_ input: String) -> Int {

    var num = divideNumber(input)

    while num >= 10 {
        num = divideNumber(String(num))
    }
    return num
}

var ri = ReadInput()

while true {
    let input = ri.read()

    if input == "0" {
        break
    }

    print(digitalRoot(input))
}
