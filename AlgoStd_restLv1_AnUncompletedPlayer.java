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
	 * �������� ���� ����
	 * 
	 * �������� ������ �̤�
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
			if(map.containsKey(c)) {	//�������� (�Ѹ� ������ ���, �θ� �� ������ ���?)
				System.out.println("c: " + c );
				return c;
			}
			
			map.put(c, "");
		}
		
		for(String s : map.keySet()) {
			System.out.println("key:" + s);
		}
		
		
		for(String p : participant) {
			if(!map.containsKey(p))	//���⼭ ���������� ������ �� ���� hash �浹���°� ��� �̿��ؾ�������
				return p;
		}
		
		return answer;
	}
	
	public static String solution2(String[] participant, String[] completion) {
		String answer = "";
		
		//���� ���� ���������..? ���� list�� array�� �߾ �Ǵ°� �ƴѰ�
		Map<String, Integer> map = new HashMap<>();	//���� �̸�, ������ ����� ��
		for(String p : participant) {
			if(map.containsKey(p)) {
				map.put(p, map.get(p)+1);
			}else 
				map.put(p, 1);
//			map.put(p, map.getOrDefault(p, 0)+1);	// ������ ���� ������ defalut�� ������
		}
		
		for(String c : completion) {
			if(1 < map.get(c)) {	//���������� �ִ� ���
				map.put(c, map.get(c)-1);
			}else {
				map.remove(c);
			}
		}
		answer = map.keySet().iterator().next();
		return answer;
	}
	
	/* ~ ��� ���� ~
	 * 
	 * �ǰ�1)
	 * keySet�ϰ� �� get�ϴ� �� �ſ� ��ȿ������ �ڵ��Դϴ�. 
	 * get�� ������ ��� HashMap�� search�ϴϱ��. key, value�� ���� ������ ���� �׻� entrySet�� ����ؾ� �ؿ�.
	 * 
	 * �ǰ�2)
	 * Entry�� getKey() / getValue()�� HashMap�� get()�� �̸��� ����� �� ���� ������ �ٸ��ϴ�. 
	 * ���ڴ� ���� ������ entry�� �Ӽ� ���� �ٷ� �������� �ݸ�, ���ڴ� (hashmap���� ã�ƾ� �ؼ�) hashcode(), equals() ���� �Լ��� ���ο��� �����ϸ� �ð��� �� ����մϴ�. 
	 * �׷� ������ entrySet ����� �����ϴ� �� �����ϴ�. 
	 * ��κ� get()�� O(1)�� �����ϸ� getValue()�� �ڸ��� O(1)������ ���� 1�� �ƴ� ��������.
	 *  �� ���� : https://stackoverflow.com/questions/3870064/performance-considerations-for-keyset-and-entryset-of-map
	 * 
	 * �ǰ�3) ���ظ���;;
	 * for �� 1�� ���࿡ �����մϴ� .
	 * public static String solution(String[] participant, String[] completion) {
	 *  HashMap map = new HashMap<>(); 
	 *  for (int i = 0; i < participant.length ; i++) {
	 *   map.compute(participant[i], (k, v) -> v != null ? null : 1);	//map.compute()�� ���ϴ¾��� �𸣰���
	 *    if (i < completion.length) map.compute(completion[i], (k,v) -> v != null ? null : 1);
	 *  } 
	 *  return map.keySet().iterator().next(); 
	 * }
	 * 
	 */
	
	
	// ������ �̿��� Ǯ��
	// 
	// ���� ���ۿ��� �ؽ���� Ÿ��Ʋ�� ��Ʈ�� ����� ������ ���ϰ��߳׿�. 
	// �ڵ�� �� ������ ������, �� �ð� ���⵵�� O(n) -> O(nLogN) ~ O(n2) ���� �þ ������ �ֽ��ϴ�.
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
	
	//linkedList�� ���� ������ Ǯ��..
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
