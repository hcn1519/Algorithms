//
//  main.swift
//  BOJ_2309
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


var candidates = Array(repeatElement(0, count: 9))
var finalResult = [Int]()
var data: [Int] = []

func checkSumIs100(A: [Int]) -> Bool {
    var result = 0
    for i in A {
        result += i
    }
    return result == 100
}

func Com(n: Int, r: Int) {
    if r == 0 {
        if checkSumIs100(A: candidates) {
            finalResult = candidates
        }
        return
    }
    if n < r {
        return
    }

    candidates[r-1] = data[n-1]
    Com(n: n-1, r: r-1)
    Com(n: n-1, r: r)
}

var ri = ReadInput()

for _ in 1...9 {
    let input = ri.readInt()
    data.append(input)
}

Com(n: 9, r: 7)

for i in finalResult.sorted() {
    if i != 0 {
        print(i)
    }
}


