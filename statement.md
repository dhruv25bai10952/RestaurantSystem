# Problem Statement

## Problem Statement

Small and mid-sized restaurants often manage table reservations, food orders, and billing manually using paper registers or informal methods. This leads to double bookings, order mix-ups, and billing errors. There is a need for a simple, reliable system to digitize these core front-of-house operations.

## Scope of the Project

This project implements a console-based restaurant management system covering three core operations:
1. Reserving tables for customers and preventing double-booking.
2. Recording food orders against a reservation using a fixed menu.
3. Generating an itemized bill (with tax and optional discount) and tracking payment status.

The system does not cover kitchen operations, staff management, inventory/stock tracking, or online/web-based booking — it is scoped strictly to reservation → order → billing workflow, run locally as a Java console application with simple file-based logging.

## Target Users

- Restaurant front-desk staff / waiters who manage table bookings and take orders.
- Restaurant owners/managers who need a simple record of daily transactions.

## High-Level Features

- View real-time table availability
- Book and cancel table reservations with customer details
- Take and finalize food orders against a browsable menu
- Auto-calculate subtotal, tax (5%), and optional loyalty discount (10%)
- Generate and track bill payment status
- Free up tables automatically once a bill is paid
- Log every generated bill to a text file for record-keeping
