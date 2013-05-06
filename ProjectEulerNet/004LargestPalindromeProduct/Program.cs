using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _004LargestPalindromeProduct
{
	class Program
	{
		private static bool IsPalindrome(int n)
		{
			int ntemp = n;
			int reverse = 0;

			while (ntemp > 0)
			{
				int a = ntemp % 10;
				ntemp = (ntemp - a) / 10;

				reverse = reverse * 10 + a;
			}

			return (reverse == n);
		}

		static void Main(string[] args)
		{
			int largestPalindrome = 0;

			for (int i = 999; i > 99; i--)
			{
				// i or j must divisible by 11
				int jStart = 999;
				int jD = 1;

				if (i % 11 != 0)
				{
					jStart = 990;
					jD = 11;
				}

				for (int j = jStart; j > i; j -= jD)
				{
					int product = i * j;

					if (product < largestPalindrome)
					{
						break;
					}

					if (IsPalindrome(product))
					{
						if (product > largestPalindrome)
						{
							largestPalindrome = product;
						}
					}
				}
			}

			Console.WriteLine(largestPalindrome);
		}
	}
}
