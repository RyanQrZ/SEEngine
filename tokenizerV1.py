# ----------------------------------------------------------
# Importa dataset

input_text = open( "the-verdict.txt", encoding="utf-8" )
text1 = input_text.read()
input_text.close()

input_text = open( "the-winepress.txt", encoding="utf-8" )
text2 = input_text.read()
input_text.close()
# ----------------------------------------------------------

# ----------------------------------------------------------
# Separacao dos tokens

import re

tokens = re.split( r'([.,()"\'?:;_!]|\s|--)', text1 )
tokens += re.split( r'([.,()"\'?:;_!]|\s|--)', text2 )
tokens = [i for i in tokens if i.strip() ]
# ----------------------------------------------------------

# ----------------------------------------------------------
# Criacao do vocabulario

all_words = sorted( set(tokens) )
# Special context tokens
all_words.extend( ["<|eot|>", "<|unk|>"] )

voc = { token_id:word for token_id,word in enumerate(all_words) }
# ----------------------------------------------------------

# ----------------------------------------------------------
# Classe tokenizadora com encoder e decoder

class Tokenizer:
    def __init__( self, vocab ):
        self.int_str = vocab
        self.str_int = {i:j for j,i in vocab.items()}

    def encode( self, text ):
        tokens = re.split( r'([.,()"\'?:;_!]|\s|--)', text )
        tokens = [i for i in tokens if i.strip()]

        id_list = [self.str_int[st] for st in tokens]

        return id_list

    def decode( self, numbers ):
        text = " ".join( [self.int_str[i] for i in numbers] )
        text = re.sub( r'\s+([.,()"\'?:;_!])', r'\1', text )

        return text

#--------------------------------------------------

class TokenizerV2:
    def __init__( self, vocab ):
        self.int_str = vocab
        self.str_int = {i:j for j,i in vocab.items()}

    def encode( self, text ):
        tokens = re.split( r'([.,()"\'?:;_!]|\s|--)', text )
        tokens = [i for i in tokens if i.strip()]
        tokens = [i if(i in self.str_int) else "<|unk|>"
                  for i in tokens]

        id_list = [self.str_int[st] for st in tokens]

        return id_list

    def decode( self, numbers ):
        text = [self.int_str[i] for i in numbers]
        text = " ".join( text )
        text = re.sub( r'\s+([.,()"\'?:;_!])', r'\1', text )

        return text
# ----------------------------------------------------------

# ----------------------------------------------------------
#text = " <|eot|> ".join( [text1, text2] )
print()
text = input()
# ----------------------------------------------------------

# ----------------------------------------------------------
#tok = Tokenizer(voc)
tok2 = TokenizerV2(voc)

print( "****************" )
print( "Vocabulary length:", len(voc) )
print()
print( tok2.encode(text) )
print()
print( tok2.decode(tok2.encode(text)) )
print( "****************" )

# https://www.youtube.com/watch?v=rsy5Ragmso8&list=PLPTV0NXA_ZSgsLAr8YCgCwhPIJNNtexWu&index=7
# ----------------------------------------------------------
