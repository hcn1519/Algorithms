//: Playground - noun: a place where people can play

import UIKit

class Person {
    var name: String
    var rank: Int
    var numberOfFriends: Int
    var parent: Person?
    
    init(name: String) {
        self.name = name
        self.rank = 0
        self.numberOfFriends = 0
        self.parent = nil
    }
    
    func getParent() -> Person {
        var me = self
        
        guard var parent = self.parent else {
            return me
        }
        
        while me.name != parent.name {
            self.parent = parent.parent
            
            me = parent
            if let p = me.parent {
                parent = p
            }
            
        }
        
        return me.parent!
    }
}

var people: [String: Person] = [:]

func mergeTable(person1: String, person2: String) {
    
    // 둘 모두 그룹에 없음
    if people[person1] == nil && people[person2] == nil {
        var p1 = Person(name: person1)
        var p2 = Person(name: person2)
        
        p1.parent = p1
        p2.parent = p1
        p1.numberOfFriends = 2
        
        people.updateValue(p1, forKey: person1)
        people.updateValue(p2, forKey: person2)
        
    
    // 한 명만 그룹 있음
    } else if people[person1] != nil && people[person2] == nil {
        var p2 = Person(name: person2)
        
        var px = people[person1]?.getParent()

        p2.parent = px
        px?.numberOfFriends += 1
        
        people.updateValue(p2, forKey: person2)
        
    // 한 명만 그룹 있음
    } else if people[person1] == nil && people[person2] != nil {
        var p1 = Person(name: person1)
        
        var px = people[person2]?.getParent()
        p1.parent = px
        px?.numberOfFriends += 1
        
        people.updateValue(p1, forKey: person1)
    // 둘 모두 그룹 있음
    } else {
        var px = people[person1]?.getParent()
        var py = people[person2]?.getParent()
        
        px?.numberOfFriends += (py?.numberOfFriends)!
        py?.parent = px
    }
    
}

mergeTable(person1: "Fred", person2: "Barney")



print(people["Fred"]!.parent?.numberOfFriends)
mergeTable(person1: "Barney", person2: "Betty")
print(people["Barney"]!.parent?.numberOfFriends)
mergeTable(person1: "Betty", person2: "Wilma")

print(people["Betty"]!.parent?.numberOfFriends)
// Fred Barney
// Barney Betty
// Betty Wilma

