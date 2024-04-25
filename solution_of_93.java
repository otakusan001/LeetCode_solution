class Solution {
    private List<String> res = new ArrayList<>();
    private List<String> record = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return res;
        backtracking(s, 0, 0);
        return res;
    }
    private void backtracking(String s, int startIndex, int pointSum){
        if(pointSum == 3){
            if(isValid(s, startIndex, s.length()-1)) {
                record.add(s.substring(startIndex));
                String str = "";
                for(int j = 0; j < record.size() - 1; j++){
                    str += record.get(j);
                    str += ".";
                }
                str += record.get(record.size() - 1);
                res.add(str);
                record.remove(record.size() - 1);
            }
            return;           
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isValid(s, startIndex, i)){
                record.add(s.substring(startIndex, i+1));
                //System.out.print("pre");
                //System.out.println(record);
                backtracking(s, i+1, pointSum+1);
                
                record.remove(record.size() - 1);
                //System.out.print("bef");
                //System.out.println(record);
            }
            else break;
        }
    }
    private boolean isValid(String s, int start, int end){
        if(start > end || end - start > 3) return false;
        if(start - end != 0 && s.charAt(start) == '0') return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
