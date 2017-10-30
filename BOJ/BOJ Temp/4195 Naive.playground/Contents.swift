//: Playground - noun: a place where people can play

import UIKit

struct Person {
    var name: String
    var key: String?

}

var people: [Person] = []
var group: [String: Int] = [:]

func groupCheck(group people: [Person], person1: String, person2: String) -> (Int, Int) {
    
    var index1: Int = -1
    var index2: Int = -1
    
    for (index, p) in people.enumerated() {
        if p.name == person1 {
            index1 = index
        } else if p.name == person2 {
            index2 = index
        }
    }
    return (index1, index2)
}

func makeGroup(person1: String, person2: String) {
    let place = groupCheck(group: people, person1: person1, person2: person2)
    
    
    if place.0 == -1 && place.1 == -1 {
        
        // 둘 다 포함된 그룹이 없는 경우
        let p1 = Person(name: person1, key: person1)
        let p2 = Person(name: person2, key: person1)
        
        people.append(p1)
        people.append(p2)
        
        group.updateValue(2, forKey: person1)
        
        print(2)
        return
    }
    
    
    // 한 명만 그룹에 포함된 경우
    if place.0 != -1 && place.1 == -1 {
        // 0이 그룹 있음
        var p2 = Person(name: person2, key: nil)
        
        p2.key = people[place.0].key
        
        people.append(p2)
        
        group[p2.key!]! += 1
        
        print(group[p2.key!]!)
        return
    } else if place.1 != -1 && place.0 == -1 {
        // 1이 그룹 있음
        var p1 = Person(name: person1, key: nil)
        
        p1.key = people[place.1].key
        
        people.append(p1)
        
        group[p1.key!]! += 1
        
        print(group[p1.key!]!)
        
        return
    }

    
    // 둘 다 포함된 그룹이 있는 경우
    let prevKey = people[place.1].key
    let updateKey = people[place.0].key
    var counter = 0
    for item in people {
        var item = item
        if item.key == prevKey {
            item.key = updateKey
            counter += 1
        }
        
    }
    group[people[place.0].key!]! += counter
    
    print(group[people[place.0].key!]!)
//    print(people)
//    print(group)
}

//makeGroup(person1: "Fred", person2: "Barney")
//
//makeGroup(person1: "Barney", person2: "Betty")
//
//makeGroup(person1: "Betty", person2: "Wilma")


makeGroup(person1: "Fred", person2: "Barney")

makeGroup(person1: "Betty", person2: "Wilma")

makeGroup(person1: "Barney", person2: "Betty")


people.removeAll()
group.removeAll()

// Fred Barney
// Barney Betty
// Betty Wilma

