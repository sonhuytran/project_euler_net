using System;

namespace LargestPrimeFactor
{
	class Program
	{
		static void Main(string[] args)
		{
			long n = 600851475143;
			long lastFactor = 2;
			bool prime = false;

			while (n > 1 && !prime)
			{
				prime = true;

				for (long i = 2; i < n / 2; i++)
				{
					if (n % i == 0)
					{
						prime = false;
						lastFactor = i;
						n /= i;
						break;
					}
				}
			}

			if (prime)
			{
				Console.WriteLine(n);
			}
		}
	}
}
