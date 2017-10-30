//
//  main.swift
//  BOJ_8741
//
//  Created by 홍창남 on 2017. 10. 24..
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

func sumOfBinary(k: Int) -> String {
    if k == 1 {
        return "1"
    }

    var result = ""
    for _ in 1...k {
        result.append("1")
    }

    for _ in 1...(k - 1) {
        result.append("0")
    }
    return result
}

var ri = ReadInput()

let k = ri.readInt()

print(sumOfBinary(k: k))

