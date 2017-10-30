//: Playground - noun: a place where people can play

import Foundation

func readString(input: String) -> [String] {

    var set: String = ""
    var setOfInput: [String] = []
    for (index, c) in input.characters.enumerated() {

        if c != "#" && c != "*" {
            set += String(c)
        }

        switch c {
        case "S", "D", "T":

            if index+1 < input.characters.count {

                let additionalOption = input[input.index(input.startIndex, offsetBy: index+1)]

                if additionalOption == "#" || additionalOption == "*" {
                    set += String(additionalOption)
                }
                setOfInput.append(set)
                set = ""

            } else {
                setOfInput.append(set)
            }
        default:
            break
        }

    }
    return setOfInput

}

func pointCalculator(oneSet: String) -> (Int, Bool) {

    var oneSet = oneSet
    var points = 0
    var multiplier = false
    if oneSet.contains("*") {
        oneSet.remove(at: oneSet.index(before: oneSet.endIndex))
        multiplier = true
    }

    var seperatedSet: [String] = []
    var bonus = -1
    if oneSet.contains("S") {
        seperatedSet = oneSet.components(separatedBy: "S")
        bonus = 0
    } else if oneSet.contains("D") {
        seperatedSet = oneSet.components(separatedBy: "D")
        bonus = 1
    } else {
        seperatedSet = oneSet.components(separatedBy: "T")
        bonus = 2
    }

    points = Int(seperatedSet[0])!
    let p = points
    switch bonus {
    case 1:
        points *= p
    case 2:
        points *= (p * p)
    default:
        break
    }

    if oneSet.contains("#") {
        points *= -1
    }

    return (points, multiplier)
}

func adjustOptionsAndPrintAnswer(setOfInput: [String]){
    var answer = 0

    var defaultPoints: [Int] = []
    var prevPoint: Int = 0
    for index in setOfInput.indices {
        let eachPoint = pointCalculator(oneSet: setOfInput[index])

        if eachPoint.1 {
            // 스타상
            if index == 0 {
                // 첫 번째 경우
                answer = eachPoint.0 * 2
                prevPoint = eachPoint.0 * 2
            } else {
                // 이외
                answer += prevPoint
                answer += eachPoint.0 * 2
                prevPoint = eachPoint.0
            }

        } else {
            answer += eachPoint.0
            prevPoint = eachPoint.0
        }
    }
    
    print(answer)
}

let input1 = "1S2D*3T"
let input2 = "1D2S#10S"
let input3 = "1D2S0T"
let input4 = "1S*2T*3S"
let input5 = "1D#2S*3S"
let input6 = "1T2D3D#"
let input7 = "1D2S3T*"

adjustOptionsAndPrintAnswer(setOfInput: readString(input: input1))
adjustOptionsAndPrintAnswer(setOfInput: readString(input: input2))
adjustOptionsAndPrintAnswer(setOfInput: readString(input: input3))
adjustOptionsAndPrintAnswer(setOfInput: readString(input: input4))
adjustOptionsAndPrintAnswer(setOfInput: readString(input: input5))
adjustOptionsAndPrintAnswer(setOfInput: readString(input: input6))
adjustOptionsAndPrintAnswer(setOfInput: readString(input: input7))



