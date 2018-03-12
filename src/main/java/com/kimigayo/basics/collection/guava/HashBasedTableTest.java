package com.kimigayo.basics.collection.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Map;
import java.util.Set;

public class HashBasedTableTest {
    public static void main(String[] args) {
        Table<String,String,Integer> table = HashBasedTable.create();
        table.put("赵盾","数学",89);
        table.put("赵盾","语文",90);
        table.put("李斯","数学",87);
        table.put("李斯","语文",88);
        table.put("伍子胥","数学",92);
        table.put("伍子胥","语文",93);

        Set<String> set = table.columnKeySet();
        for (String s:set){
            System.out.print("\t"+s+"\t");
        }
        System.out.println();
        Set<String> rowKeySet = table.rowKeySet();
        for (String s:rowKeySet) {
            Map<String,Integer> map = table.row(s);
            Set<Map.Entry<String,Integer>> set1 = map.entrySet();
            System.out.print(s);
            for(Map.Entry<String,Integer>  entry :set1){
                System.out.print("\t\t"+entry.getValue());
            }
            System.out.println();
        }
        System.out.println("==========转换=========");
        Table<String,String,Integer> table1 = Tables.transpose(table);
        Set<Table.Cell<String,String,Integer>> cells = table1.cellSet();
        for (Table.Cell<String,String,Integer> cell:cells)
            System.out.println(cell.getRowKey()+"\t\t"+cell.getColumnKey()+"\t\t"+cell.getValue());
    }
}
