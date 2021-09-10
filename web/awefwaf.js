function solution(board, moves) {
    var answer = 0;
    var alist = [];
    for (var i = 0; i < moves.length; i++) {
        for (var j = 0; j < board[moves[i] - 1].length; j++) {
            if (board[moves[i] - 1][board[moves[i] - 1].length - j - 1] !== 0) {
                alist.push(board[moves[i] - 1][board[moves[i] - 1].length - j - 1]);
                board[moves[i] - 1][board[moves[i] - 1].length - j - 1] = 0;
                if (alist[alist.length-1] === alist[alist.length-2]){
                    answer = answer + 2;
                    alist.pop();
                    alist.pop();
                }
                break;
            }
        }
    }
    return answer;
}