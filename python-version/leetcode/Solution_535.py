class Codec:

    def __init__(self):
        self.database = {}
        self.id = 0

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        self.id += 1
        self.database[self.id] = longUrl

        return "http://tinyurl.com/" + str(self.id)


    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        id = int(shortUrl.split('/')[-1])
        return self.database[id]
