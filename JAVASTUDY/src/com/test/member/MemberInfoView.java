/*
 * package com.test.member;
 * 
 * import java.util.ArrayList;
 * import java.util.HashMap;
 * import java.util.List;
 * import java.util.Map;
 * 
 * public class MemberInfoView {
 * public static void main(String[] args) {
 * 
 * List<Member> list = new ArrayList<>(); // 동적 배열을 기원하는 Collector Framework
 * list.add(new Member("김철수", "남성", 23));
 * list.add(new Member("노철수", "남성", 25));
 * list.add(new Member("김수지", "여성", 22));
 * list.add(new Member("박민지", "여성", 27));
 * list.add(new Member("안철수", "남성", 10));
 * 
 * for (Member member : list) {
 * 
 * System.out.println(member.getName() + "\t" + member.getGender() + "\t" +
 * member.getAge());
 * }
 * 
 * System.out.print("\n");
 * 
 * for (int i = 0; i < list.size(); i++) {
 * System.out.println(list.get(i).getName() + "\t" + list.get(i).getGender() +
 * "\t" + list.get(i).getAge());
 * }
 * 
 * List<Map<Integer, Integer>> listFruits = new ArrayList<>();
 * 
 * int aa = 0;
 * 
 * for (int i = 0; i < 3; i++) {
 * Map<Integer, Integer> map = new HashMap<>();
 * 
 * map.put(i, aa * 10);
 * aa++;
 * listFruits.add(map);
 * System.out.println(listFruits.get(i).toString());
 * }
 * 
 * }
 * 
 * }
 */
