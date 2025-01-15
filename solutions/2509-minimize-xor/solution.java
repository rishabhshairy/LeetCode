class Solution {
    public int minimizeXor(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }

        int targetBit = Integer.bitCount(num2);
        int result = num1;
        int resultBit = Integer.bitCount(result);

        int currentBit = 0;

        // add bits to result if result  have less than target bit
        while (resultBit < targetBit) {
            if (!isBitSet(result, currentBit)) {
                result = setBit(result, currentBit);
                resultBit++;
            }
            currentBit++;
        }

        while (resultBit > targetBit) {
            if (isBitSet(result, currentBit)) {
                result = unset(result, currentBit);
                resultBit--;
            }
            currentBit++;
        }
        return result;
    }

    private int unset(int num, int currentBit) {
        return ~(1 << currentBit) & num;
    }

    private int setBit(int num, int currentBit) {
        return (1 << currentBit) | num;
    }

    //
    private boolean isBitSet(int num, int currentBit) {
        return ((1 << currentBit) & num) != 0;
    }
}
