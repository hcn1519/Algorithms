//: Playground - noun: a place where people can play

import UIKit


func runtimeCalculator(cacheSize: Int, cities: [String]) -> Int {
    var runTime = 0

    var caches: [String] = []
    if !(cacheSize < 1) {
        caches = Array(repeatElement("", count: cacheSize))
    } else {
        // 사이즈가 0일 경우
        return cities.count * 5
    }

    var index = 0
    for city in cities {
        let lowerCity = city.lowercased()

        if !caches.contains(lowerCity) {
            // 없음
            runTime += 5
            if index < cacheSize {
                caches[index] = lowerCity
                index += 1
            } else {
                // index = 배열 길이
                index = 0
                caches[index] = lowerCity
                index += 1
            }

        } else {
            // 있음
            runTime += 1
        }
    }
    return runTime
}

let cacheSize = [3, 3, 2, 5, 2, 0]
let cities = [ ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"],
               ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"],
               ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"],
               ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"],
               ["Jeju", "Pangyo", "NewYork", "newyork"],
               ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
            ]
let result = [50, 21, 60, 52, 16, 25]

for i in 0..<6 {
    if result[i] == runtimeCalculator(cacheSize: cacheSize[i], cities: cities[i]) {
        print("\(i+1)번 예시 O")
    } else {
        print("\(i+1)번 예시 X")
    }
}

