class Solution:

    def encode(self, strs: List[str]) -> str:
        output_str = ""
        for s in strs:
            output_str += str(len(s)) + "#" + s
        return output_str

    def decode(self, s: str) -> List[str]:
        output_arr = []
        i = 0

        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1
            length = int(s[i:j])
            i = j + 1
            j = i + length
            output_arr.append(s[i:j])
            print(output_arr)
            i = j
        
        return output_arr

