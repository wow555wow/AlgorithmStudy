package level1;

import java.util.*;

public class AlgoStd_restLv1_AnUncompletedPlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("leo".hashCode());
//		System.out.println("leo".hashCode());
		
		System.out.print(solution2(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
	}
	
	/**
	 * 완주하지 못한 선수
	 * 
	 * 동명이인 도르신 ㅜㅜ
	 * 
	 * @param participant
	 * @param completion
	 * @return
	 */
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Map<String, String> map = new HashMap<>();
		for(String c : completion) {
			System.out.println(c);
			if(map.containsKey(c)) {	//동명이인 (한명만 완주한 경우, 두명 다 완주한 경우?)
				System.out.println("c: " + c );
				return c;
			}
			
			map.put(c, "");
		}
		
		for(String s : map.keySet()) {
			System.out.println("key:" + s);
		}
		
		
		for(String p : participant) {
			if(!map.containsKey(p))	//여기서 동명이인을 가려낼 수 없음 hash 충돌나는걸 어떻게 이용해야하지ㅠ
				return p;
		}
		
		return answer;
	}
	
	public static String solution2(String[] participant, String[] completion) {
		String answer = "";
		
		//굳이 맵을 써야했을까..? 대충 list나 array로 했어도 되는거 아닌가
		Map<String, Integer> map = new HashMap<>();	//선수 이름, 동명인 사람의 수
		for(String p : participant) {
			if(map.containsKey(p)) {
				map.put(p, map.get(p)+1);
			}else 
				map.put(p, 1);
//			map.put(p, map.getOrDefault(p, 0)+1);	// 있으면 값을 없으면 defalut를 가져옴
		}
		
		for(String c : completion) {
			if(1 < map.get(c)) {	//동명이인이 있는 경우
				map.put(c, map.get(c)-1);
			}else {
				map.remove(c);
			}
		}
		answer = map.keySet().iterator().next();
		return answer;
	}
	
	/* ~ 토론 내용 ~
	 * 
	 * 의견1)
	 * keySet하고 또 get하는 건 매우 비효율적인 코드입니다. 
	 * get할 때마다 계속 HashMap을 search하니까요. key, value를 같이 가져올 때는 항상 entrySet을 사용해야 해요.
	 * 
	 * 의견2)
	 * Entry의 getKey() / getValue()와 HashMap의 get()은 이름이 비슷할 뿐 내부 과정은 다릅니다. 
	 * 전자는 현재 차례의 entry의 속성 값을 바로 가져오는 반면, 후자는 (hashmap에서 찾아야 해서) hashcode(), equals() 등의 함수를 내부에서 실행하며 시간을 더 사용합니다. 
	 * 그런 점에서 entrySet 사용을 권장하는 것 같습니다. 
	 * 대부분 get()은 O(1)에 수렴하며 getValue()도 자명한 O(1)이지만 같은 1이 아닌 것이지요.
	 *  ㄴ 참조 : https://stackoverflow.com/questions/3870064/performance-considerations-for-keyset-and-entryset-of-map
	 * 
	 * 의견3) 이해못함;;
	 * for 문 1번 수행에 가능합니다 .
	 * public static String solution(String[] participant, String[] completion) {
	 *  HashMap map = new HashMap<>(); 
	 *  for (int i = 0; i < participant.length ; i++) {
	 *   map.compute(participant[i], (k, v) -> v != null ? null : 1);	//map.compute()가 뭐하는앤지 모르겠음
	 *    if (i < completion.length) map.compute(completion[i], (k,v) -> v != null ? null : 1);
	 *  } 
	 *  return map.keySet().iterator().next(); 
	 * }
	 * 
	 */
	
	
	// 정렬을 이용한 풀이
	// 
	// 문제 시작에서 해쉬라는 타이틀이 소트를 사용할 생각을 못하게했네요. 
	// 코드는 더 간단해 졌지만, 단 시간 복잡도가 O(n) -> O(nLogN) ~ O(n2) 으로 늘어난 단점이 있습니다.
//	class Solution {
//	    public String solution(String[] participant, String[] completion) {
//	        Arrays.sort(participant);
//	        Arrays.sort(completion);
//	        int i;
//	        for ( i=0; i<completion.length; i++){
//
//	            if (!participant[i].equals(completion[i])){
//	                return participant[i];
//	            }
//	        }
//	        return participant[i];
//	    }
//	}
	
	//linkedList를 직접 구현한 풀이..
//	public class Solution {
//
//	    int bucketSize;
//	    List<Entry>[] bucket;
//
//	    public String solution(String[] participant, String[] completion) {
//	        bucketSize = (completion.length / 5)+1;
//	        bucket = new List[bucketSize];
//
//	        for (int i = 0; i < completion.length; i++) {
//	            Entry entry = get(completion[i]);
//	            entry.value += 1;
//	        }
//
//	        for (int i = 0; i < participant.length; i++) {
//	            Entry entry = get(participant[i]);
//	            if (entry != null && entry.value > 0) {
//	                entry.value -= 1;
//	            } else {
//	                return entry.key;
//	            }
//	        }
//	        throw new RuntimeException("error");
//	    }
//
//	    private Entry get(String s) {
//	        int idx = hash(s);
//	        List<Entry> list = bucket[idx];
//	        if (list == null) {
//	            list = new List<Entry>();
//	            Entry entry = new Entry(s, 0);
//	            list.add(entry);
//	            bucket[idx] = list;
//	            return entry;
//	        } else {
//	            Entry entry = list.get(s);
//	            if (entry == null) {
//	                entry = new Entry(s, 0);
//	                list.add(entry);
//	            }
//	            return entry;
//	        }
//	    }
//
//
//	    private int hash(String s) {
//	        int num = 0;
//	        for(int i=0; i<s.length(); i++) {
//	            num += s.codePointAt(i) * 31 + s.codePointAt(i);
//	        }
//	        return num % bucketSize;
//	    }
//
//	    class Entry {
//	        String key;
//	        int value;
//
//	        public Entry(String key, int value) {
//	            this.key = key;
//	            this.value = value;
//	        }
//	    }
//
//	    class List<T extends Entry> {
//	        Node head;
//
//	        public void add(T entry) {
//	            Node nn = new Node(entry, null);
//
//	            if (head == null) {
//	                head = nn;
//	            } else {
//	                Node last = head;
//	                while (last.next != null) {
//	                    last = last.next;
//	                }
//	                last.next = nn;
//	            }
//	        }
//
//	        public <T extends Entry> T get(String s) {
//	            Node node = head;
//	            while (node != null) {
//	                if (node.data.key.equals(s)) {
//	                    return (T) node.data;
//	                }
//	                node = node.next;
//	            }
//
//	            return null;
//	        }
//
//	        class Node<T extends Entry> {
//	            T data;
//	            Node next;
//
//	            public Node(T data, Node next) {
//	                this.data = data;
//	                this.next = next;
//	            }
//	        }
//	    }
//
//	    public static void main(String[] args) {
//	        String[] p = {"mislav", "stanko", "mislav", "ana"};
//	        String[] c = {"stanko", "ana", "mislav"};
//	        Solution s = new Solution();
//	        String answer = s.solution(p, c);
//	        System.out.println(answer);
//	    }
//
//	}

}
