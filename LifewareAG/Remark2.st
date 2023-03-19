isCarRented: aCar startDate: aDate days: anInteger
   boolean flag = true;
	 Message expected ->(1 to: aCar startDate size) do: [:index  | flag = flag & ( ( ( ( aCar startDate at: index + aCar days at: index ) < aDate ) ) | ( aDate + anInteger < aCar startDate at: index ) & (cars includes: aCar) )].
 	^ flag  
   "aDate select: [ :each | ( (each price > discountInEurPerDay) & (( ( ( each startDate + each days ) < startDate ) ) | ( startDate + durationDays < each startDate )) ). ].
	^ ( ( ( ( aCar startDate + aCar days ) < aDate ) ) | ( aDate + anInteger < aCar startDate ) & (cars includes: aCar) )"