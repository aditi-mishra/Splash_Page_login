/*
 * exp4_interrupt.c
 *
 *  Created on: Oct 30, 2017
 *      Author: DXer
 */

#include <avr/io.h>
#include <avr/interrupt.h>    // Needed to use interrupts

#include <util/delay.h>

int main(void)
{
	/*Input button*/
    DDRD &= ~(1 << DDD2);         // Clear the PD2 pin
    // PD2 (PCINT0 pin) is now an input
    PORTD |= ~(1 << PORTD2);        // turn Off the Pull-up

    PCICR |= (1 << PCIE0);     // set PCIE0 to enable PCMSK0 scan
    PCMSK0 |= (1 << PCINT0);   // set PCINT0 to trigger an interrupt on state change

    sei();                     // turn on interrupts

    DDRB |= _BV(DDB5);
    while(1)
    {
        /*main program loop here */PORTB &= ~_BV(PORTB5);
    }
}



ISR (PCINT0_vect)
{
	PORTB |= _BV(PORTB5);
    	_delay_ms(1000);

}



