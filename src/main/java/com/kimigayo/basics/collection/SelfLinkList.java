package com.kimigayo.basics.collection;

public class SelfLinkList<T> {
    private Node first;
    private Node last;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(T t) {
        if (null == first) {
            Node node = new Node(null, t, null);
            this.first = node;
            this.last = node;
        } else {
            Node node = new Node(last, t, null);
            last.setAft(node);
            this.last = node;
        }
        size++;
    }

    public T get(int index) throws Exception {
        if(index>=size){
            throw new Exception("请输入正确参数");
        }
        if (index < size >> 1) {
            Node node = first;
            for (int i=0;i<index;i++){
                node = node.aft;
            }
            return (T) node.getValue();
        }else {
            Node node = last;
            for (int i=0;i<size-index-1;i++){
                node = node.pre;
            }
            return (T) node.getValue();
        }
    }

    public void remove(T t){
        Node  node = first;
        if(first.getValue().equals(t)){
            Node aft = node.aft;
            aft.setPre(node.pre);
            this.first = aft;
            size--;
        }else if(last.getValue().equals(t)){
            Node pre = last.pre;
            this.last = pre;
            pre.setAft(node.aft);
            size--;
        }else {
            while(null!=node.aft) {
                node = node.aft;
                if (node.getValue().equals(t)) {
                    Node aft = node.aft;
                    Node pre = node.pre;
                    aft.setPre(node.pre);
                    pre.setAft(aft);
                    size--;
                }
            }
        }
    }

    private class Node {
        private Node pre;
        private Object value;
        private Node aft;

        public Node(Node pre, Object value, Node aft) {
            this.pre = pre;
            this.value = value;
            this.aft = aft;
        }

        public Node() {
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getAft() {
            return aft;
        }

        public void setAft(Node aft) {
            this.aft = aft;
        }

        public Object getValue() {
            return value;
        }
    }
}
