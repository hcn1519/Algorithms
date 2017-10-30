//: Playground - noun: a place where people can play

import UIKit
import Foundation

func generateSet(str: String) -> [String: Int] {
    var set: [String: Int] = [:]

    for (i, c) in str.enumerated() {
        if i + 1 < str.count {
            let element = String(c) + String(str[str.index(str.startIndex, offsetBy: i+1)])

            // 특수문자 제외, 알파벳만
            if NSPredicate(format: "SELF MATCHES %@", "^[a-zA-Z]+$").evaluate(with: element) {
                if set[element] == nil {
                    set[element] = 1
                } else {
                    set[element]! += 1
                }
            }
        }
    }

    return set
}

// 교집합 길이 만들기
func generateIntersection(str1: [String: Int], str2: [String: Int]) -> Double {

    var result: [String: Int] = [:]
    for (key, value) in str1 {
        if let value2 = str2[key] {
            if value2 <= value {
                result.updateValue(value2, forKey: key)
            } else {
                result.updateValue(value, forKey: key)
            }
        }
    }

    var intersectionLength = 0
    for (_, value) in result {
        intersectionLength += value
    }
    return Double(intersectionLength)
}

// 합집합 길이 만들기
func generateUnion(str1: [String: Int], str2: [String: Int]) -> Double {

    var result: [String: Int] = str1

    for (key, value) in str2 {
        if result[key] == nil {
            result.updateValue(value, forKey: key)
        } else {
            if result[key]! <= value {
                result.updateValue(value, forKey: key)
            }
        }
    }

    var unionLength = 0
    for (_, value) in result {
        unionLength += value
    }
    return Double(unionLength)
}

func jakad(str1: String, str2: String) {
    let lowerStr1 = str1.lowercased()
    let lowerStr2 = str2.lowercased()

    let set1 = generateSet(str: lowerStr1)
    let set2 = generateSet(str: lowerStr2)

    let interSectionCount = generateIntersection(str1: set1, str2: set2)
    let unionCount = generateUnion(str1: set1, str2: set2)

    if unionCount == 0 {
        print(65536)
    } else {
        let similarity: Double = interSectionCount / unionCount
        let resultSimilarity = Int(similarity * 65536)

        print(resultSimilarity)
    }
}

jakad(str1: "FRANCE", str2: "french")
jakad(str1: "handshake", str2: "shake hands")
jakad(str1: "aa1+aa2", str2: "AAAA12")
jakad(str1: "E=M*C^2", str2: "e=m*c^2")
