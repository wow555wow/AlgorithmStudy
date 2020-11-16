def solution(phone_number):
    answer = ''
    
    #i=0
    #while(i<len(phone_number)-4) :
    length = len(phone_number)
    for number in range(length-4):
        answer += '*'
        #i += 1
    
    answer += phone_number[length-4:]
    
    
    return answer


## 다른 사람의 풀이
def hide_number(s) :
  return '*' * (len(s)-4) + s[-4:]

# 괄호{} 사용하지 않고 : 사용
# 들여쓰기 반드시 맞춰줘야 함(안맞추면 syntax err)

# 문자열 곱셈 가능
# 문자열 길이 : len(문자열)
# 음수 index 사용 가능(맨 뒤에서 -)
