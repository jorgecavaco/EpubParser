package com.codefan.epubutils;

public class Runner {

	public static void main(String[] args) {
		try {

			Reader reader = new Reader();

			reader.setMaxContentPerSection(1250);
			reader.setCssStatus(CssStatus.OMIT);
			reader.setIsIncludingTextContent(true);

			reader.setFullContent("C:\\eBooks/Alice in Wonderland.epub"); // shute-lonely-road

			// Package infoPackage = reader.getInfoPackage();
			// infoPackage.getMetadata().getLanguage();
			// reader.getCoverImage();

			// int k = 0;
			// for (int i = 0; i < 50; i++) {
			//
			// bookSection = epubContent.getBookSection(k);
			// System.out.println("\n" + k + "st Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			//
			// System.out.println("content: " + getHtmlBody(bookSection.getSectionContent()));
			//
			// k += getRandomBoolean() ? 1 : -1;
			//
			// if (k < 0)
			// k += 2;
			// }

			// TODO: shute-lonely-road 219. index calculateTrimEndPosition yanl�� hesaplan�yor.

			BookSection bookSection;

			bookSection = reader.readSection(1);
			System.out.println("\n" + 1 + "st Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			System.out.println("content: " + getHtmlBody(bookSection.getSectionContent()));
			bookSection = reader.readSection(0);
			System.out.println("\n" + 0 + "st Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			System.out.println("content: " + getHtmlBody(bookSection.getSectionContent()));

			// for (int i = 0; i < 550; i++) {
			// bookSection = reader.readSection(i);
			// System.out.println("\n" + i + "st Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			//
			// // System.out.println("content: " + bookSection.getSectionContent());
			// System.out.println("content: " + getHtmlBody(bookSection.getSectionContent()));
			// }
			//
			// System.out.println("\n-------------------------------Going backwards!-------------------------------------\n");
			//
			// for (int i = 548; i >= 0; i--) {
			// bookSection = reader.readSection(i);
			// System.out.println("\n" + i + "st Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			//
			// System.out.println("content: " + getHtmlBody(bookSection.getSectionContent()));
			// // System.out.println("content: " + bookSection.getSectionContent());
			// }

			// int x = 5;

			// bookSection = epubContent.getNextBookSection();
			// System.out.println("\n3rd Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			//
			// bookSection = epubContent.getPrevBookSection();
			// System.out.println("\n2nd Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			//
			// bookSection = epubContent.getBookSection(0);
			// System.out.println("\n1st Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());
			//
			// bookSection = epubContent.getBookSection(1);
			// System.out.println("\n2nd Book Section: \nlabel: " + bookSection.getLabel() + "; media-type: " + bookSection.getMediaType());

		} catch (ReadingException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (OutOfPagesException e) {
			e.printStackTrace();
			System.out.println(e.toString() + "--------------------------------------------------------------------------------");
		}
	}

	private static String getHtmlBody(String htmlContent) throws ReadingException {
		int startOfBody = htmlContent.indexOf(Constants.TAG_BODY_START);
		int endOfBody = htmlContent.indexOf(Constants.TAG_BODY_END);

		if (startOfBody != -1 && endOfBody != -1) {
			return htmlContent.substring(startOfBody + Constants.TAG_BODY_START.length(), endOfBody);
		} else {
			throw new ReadingException("Exception while getting book section : Html body tags not found.");
		}
	}

	public static boolean getRandomBoolean() {
		return Math.random() < 0.5;
	}

}
