/**
 * @param {string} word
 * @return {string}
 */
var compressedString = function(word) {
    let res = '', count = 1;
    for (let i = 1; i <= word.length; i++) {
        if (word[i] === word[i - 1] && count < 9) count++;
        else res += count + word[i - 1], count = 1;
    }
    return res;
};
