class Solution3:
    def minimumLengthEncoding(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        count = 0
        for i in range(0,len(words)):
            words[i] = words[i][::-1]
        sort_words = sorted(words)
        #print(sort_words)
        temp_list = list([sort_words[0]])
        temp_first_word = sort_words[0][0]
        sum = len(sort_words[0])
        word_count = 0
        # iterate each word in sorted words
        for i in range(1,len(sort_words)):
            if sort_words[i][0] == temp_first_word:
                # if the first words are same then compare it with the word in temp_list
                flag = False
                for word in temp_list:
                    
                    #print("sort_words : %s , word : %s"%(sort_words[i],word))
                    if len(sort_words[i]) == len(word):
                        #print("length equal")
                        if sort_words[i] == word:
                            flag = True
                            break
                    elif len(sort_words[i]) > len(word):
                        #print("len sorted word : %s , len word %s"%(len(sort_words[i]),len(word)))
                        if sort_words[i][0:len(word)] == word:
                            temp_list.remove(word)
                            temp_list.append(sort_words[i])
                            sum += len(sort_words[i])-len(word)
                            flag = True
                            break
                    else:
                        if sort_words[i] == word[0:len(sort_words[i])]:
                            #print("hahah")
                            flag = True
                            break
                if not flag:
                    temp_list.append(sort_words[i])
                    sum+=len(sort_words[i])
            else:
                word_count += len(temp_list)
                temp_list = list([sort_words[i]])
                sum+=len(sort_words[i])
                temp_first_word = sort_words[i][0]
        if len(temp_list) != 0 :
            word_count += len(temp_list)
            temp_list = list([sort_words[i]])
            temp_first_word = sort_words[i][0]
        return sum+word_count

if __name__ == "__main__":
    s3 = Solution3()
    words = list(["time","me"])
    print("return number %s" % (s3.minimumLengthEncoding(words)))



