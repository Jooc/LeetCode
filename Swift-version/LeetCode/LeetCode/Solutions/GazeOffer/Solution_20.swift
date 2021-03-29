//
//  Solution_20.swift
//  LeetCode
//
//  Created by 齐旭晨 on 2021/3/29.
//

import Foundation

class Solution_20: Solution{
    func main() {
        print(isNumber("-1.e49046 "))
    }
    
    func isNumber(_ s: String) -> Bool {
        var state: State? = State.startBlank
        for ch in s{
            state = state!.apply(input: ch)
            guard state != nil else {
                return false
            }
        }
        return state! == .digit || state! == .dotDigit || state! == .sDigit || state! == .endBlank
    }
    
    enum State: Int{
        case startBlank = 0
        case sign = 1
        case digit = 2
        case dotDigit = 3
        case dotDigitAfterBlank = 4
        case e = 5
        case eSign = 6
        case sDigit = 7
        case endBlank = 8
        
        func apply(input: Character) -> State?{
            if input.isWhitespace{
                return applyBlank()
            }else if input == "+" || input == "-"{
                return applySign()
            }else if input.isNumber{
                return applyDigit()
            }else if input == "."{
                return applyDot()
            }else if input == "e" || input == "E"{
                return applyE()
            }else{
                return nil
            }
        }
        
        func applyBlank() -> State?{
            switch self {
            case .startBlank: return .startBlank
            case .digit: return .endBlank
            case .dotDigit: return .endBlank
            case .sDigit: return .endBlank
            case .endBlank: return .endBlank
            default: return nil
            }
        }
        
        func applySign() -> State?{
            switch self {
            case .startBlank: return .sign
            case .e: return .eSign
            default: return nil
            }
        }
        
        func applyDigit() -> State?{
            switch self {
            case .startBlank: return .digit
            case .sign: return .digit
            case .digit: return .digit
            case .dotDigit: return .dotDigit
            case .dotDigitAfterBlank: return .dotDigit
            case .e: return .sDigit
            case .eSign: return .sDigit
            case .sDigit: return .sDigit
            default: return nil
            }
        }
        
        func applyDot() -> State?{
            switch self {
            case .startBlank: return .dotDigitAfterBlank
            case .sign: return .dotDigitAfterBlank
            case .digit: return .dotDigit
            default: return nil
            }
        }
        
        func applyE() -> State?{
            switch self {
            case .digit: return .e
            case .dotDigit: return .e
            default: return nil
            }
        }
    }
}
